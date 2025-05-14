package edu.citadel.cprl;

import edu.citadel.compiler.Position;
import edu.citadel.compiler.ParserException;
import edu.citadel.compiler.InternalCompilerException;
import edu.citadel.compiler.ErrorHandler;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;
import static edu.citadel.cprl.FirstFollowSets.*;
import edu.citadel.cprl.ast.*;

public class Parser {

    private Scanner scanner;
    private IdTable idTable;
    private LoopContext loopContext;
    private SubprogramContext subprogramContext;

    /**
     * Constrói um analisador sintático (parser) com um scanner especificado.
     */
    public Parser( Scanner scanner ) {
        
        this.scanner = scanner;
        this.idTable = new IdTable();
        this.loopContext = new LoopContext();
        this.subprogramContext = new SubprogramContext();
        
    }
    
    /**
     * Analisa a regra gramatical abaixo:
     * 
     * program = declarativePart statementPart "." .
     */
    public Program parseProgram() throws IOException {
        
        try {
            
            DeclarativePart declPart = parseDeclarativePart();
            StatementPart stmtPart = parseStatementPart();
            match( Symbol.dot );
            match( Symbol.EOF );
            return new Program( declPart, stmtPart );
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "program" ) );
            return null;
        }
        
    }

    /**
     * Analisa a regra gramatical abaixo:
     * 
     * declarativePart = initialDecls subprogramDecls .
     */
    public DeclarativePart parseDeclarativePart() throws IOException {
        
        List<InitialDecl> initialDecls = parseInitialDecls();
        List<SubprogramDecl> subprogDecls = parseSubprogramDecls();

        return new DeclarativePart( initialDecls, subprogDecls );
        
    }

    /**
     * Analisa a regra gramatical abaixo:
     * 
     * initialDecls = ( initialDecl )* .
     */
    public List<InitialDecl> parseInitialDecls() throws IOException {
        
        List<InitialDecl> initialDecls = new ArrayList<>();

        while ( scanner.getSymbol().isInitialDeclStarter() ) {
            
            InitialDecl decl = parseInitialDecl();

            if ( decl instanceof VarDecl ) {
                VarDecl varDecl = (VarDecl) decl;
                for ( SingleVarDecl singleVarDecl : varDecl.getSingleVarDecls() ) {
                    initialDecls.add( singleVarDecl );
                }
            } else {
                initialDecls.add( decl );
            }
            
        }

        return initialDecls;
        
    }

    /**
     * Analisa a regra gramatical abaixo:
     * 
     * initialDecl = constDecl | arrayTypeDecl | varDecl .
     */
    public InitialDecl parseInitialDecl() throws IOException { // não mexer
        
        if ( scanner.getSymbol() == Symbol.constRW ) {
            return parseConstDecl();
        } else if ( scanner.getSymbol() == Symbol.typeRW ) {
            return parseArrayTypeDecl();
        } else if ( scanner.getSymbol() == Symbol.varRW ) {
            return parseVarDecl();
        } else {
            throw internalError( "Invalid initial decl." );
        }
        
    }

    /**
     * Analisa a regra gramatical abaixo:
     * 
     * constDecl = "const" constId ":=" literal ";" .
     */
    public ConstDecl parseConstDecl() throws IOException { // implementado
        
        try {
            
            match( Symbol.constRW );
            
            Token constId = scanner.getToken();
            match( Symbol.identifier );
            
            match( Symbol.assign );
            Token literal = parseLiteral();
            match( Symbol.semicolon );
            
            Type constType = Type.UNKNOWN;
            if ( literal != null ) {
                constType = Type.getTypeOf( literal.getSymbol() );
            }
            
            ConstDecl constDecl = new ConstDecl( 
                    constId, 
                    constType, 
                    literal );
            
            idTable.add( constDecl );
            
            return constDecl;
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "constDecl" ) );
            return null;
        }
        
    }

    /**
     * Analisa as regras gramaticais abaixo:
     * 
     *        literal = intLiteral | charLiteral | stringLiteral | booleanLiteral .
     * booleanLiteral = "true" | "false" .
     */
    public Token parseLiteral() throws IOException {
        
        try {
            
            if ( scanner.getSymbol().isLiteral() ) {
                Token literal = scanner.getToken();
                matchCurrentSymbol();
                return literal;
            } else {
                throw error( "Invalid literal expression." );
            }
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "literal" ) );
            return null;
        }
        
    }

    /**
     * Analisa a regra gramatical abaixo:
     * 
     * varDecl = "var" identifiers ":" typeName ";" .
     */
    public VarDecl parseVarDecl() throws IOException {
        
        try {
            
            match( Symbol.varRW );
            List<Token> identifiers = parseIdentifiers();
            match( Symbol.colon );
            Type typeName = parseTypeName();
            match( Symbol.semicolon );

            VarDecl varDecl = new VarDecl( identifiers, typeName, idTable.getScopeLevel() );

            for ( SingleVarDecl decl : varDecl.getSingleVarDecls() ) {
                idTable.add( decl );
            }

            return varDecl;
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "varDecl" ) );
            return null;
        }
        
    }

    /**
     * Analisa a regra gramatical abaixo:
     * 
     * identifiers = identifier ( "," identifier )* .
     *
     * @return uma lista de tokens do tipo identificador. Retorna uma lista
     * vazia caso a análise falhe.
     */
    public List<Token> parseIdentifiers() throws IOException {
        
        try {
            
            List<Token> identifiers = new ArrayList<>();
            Token idToken = scanner.getToken();
            match( Symbol.identifier );
            identifiers.add( idToken );

            while ( scanner.getSymbol() == Symbol.comma ) {
                matchCurrentSymbol();
                idToken = scanner.getToken();
                match( Symbol.identifier );
                identifiers.add( idToken );
            }

            return identifiers;
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "identifiers" ) );
            return Collections.emptyList();
        }
        
    }

    /**
     * Analisa a regra gramatical abaixo:
     * 
     * arrayTypeDecl = "type" typeId "=" "array" "[" intConstValue "]" "of" typeName ";" .
     */
    public ArrayTypeDecl parseArrayTypeDecl() throws IOException { // implementado 
  
        
        try {
            
            match(Symbol.typeRW);
            List<Token> identifiers = parseIdentifiers();
            Token arrayId = identifiers.get(0);
            Position errorPos = null;
            match(Symbol.equals);
            match(Symbol.arrayRW);
            match(Symbol.leftBracket);
            ConstValue cv = parseConstValue();
            
            if (cv == null) {
                cv = new ConstValue(new Token(Symbol.intLiteral, scanner.getPosition(), "0"));
            }
            
            match(Symbol.rightBracket);
            match(Symbol.ofRW);
            Type t = parseTypeName();
            ArrayTypeDecl array = new ArrayTypeDecl(arrayId, t, cv);
            idTable.add(array);
            match(Symbol.semicolon);
            
            if (errorPos != null) {
                throw error(errorPos, "Invalid constant.");
            }
            
            return array;
        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("arrayTypeDecl"));
            return null;
        }
        
    }

    /**
     * Analisa a regra gramatical abaixo:
     * 
     * typeName = "Integer" | "Boolean" | "Char" | typeId .
     */
    public Type parseTypeName() throws IOException {
        
        Type type = Type.UNKNOWN;
        
        try {
            
            if ( scanner.getSymbol() == Symbol.IntegerRW ) {
                type = Type.Integer;
                matchCurrentSymbol();
            } else if ( scanner.getSymbol() == Symbol.BooleanRW ) {
                type = Type.Boolean;
                matchCurrentSymbol();
            } else if ( scanner.getSymbol() == Symbol.CharRW ) {
                type = Type.Char;
                matchCurrentSymbol();
            } else if ( scanner.getSymbol() == Symbol.identifier ) {
                
                Token typeId = scanner.getToken();
                matchCurrentSymbol();
                Declaration decl = idTable.get( typeId );

                if ( decl != null ) {
                    if ( decl instanceof ArrayTypeDecl ) {
                        type = decl.getType();
                    } else {
                        throw error( typeId.getPosition(), "Identifier \""
                                     + typeId + "\" is not a valid type name." );
                    }
                } else {
                    throw error( typeId.getPosition(), "Identifier \""
                                 + typeId + "\" has not been declared." );
                }
                
            } else {
                throw error( "Invalid type name." );
            }
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "typeName" ) );
        }
        
        return type;
        
    }

    /**
     * Analisa a regra gramatical abaixo:
     * 
     * subprogramDecls = ( subprogramDecl )* .
     */
    public List<SubprogramDecl> parseSubprogramDecls() throws IOException { // implementado    
         
        List<SubprogramDecl> subprogramDecls = new ArrayList<>();
       
        while ( scanner.getSymbol().isSubprogramDeclStarter() ) {
            subprogramDecls.add(parseSubprogramDecl());
        }
        
        return subprogramDecls;
        
    }

    /**
     * Analisa a regra gramatical abaixo:
     * 
     * subprogramDecl = procedureDecl | functionDecl .
     */
    public SubprogramDecl parseSubprogramDecl() throws IOException {
        
        if ( scanner.getSymbol() == Symbol.procedureRW ) {
            return parseProcedureDecl();
        } else if ( scanner.getSymbol() == Symbol.functionRW ) {
            return parseFunctionDecl();
        } else {
            throw internalError( "Invalid subprogram decl." );
        }

    }

    /**
     * Analisa a regra gramatical abaixo:
     * 
     * procedureDecl = "procedure" procId ( formalParameters )? "is" initialDecls statementPart procId ";" .
     */
    public ProcedureDecl parseProcedureDecl() throws IOException {
        
        try {
            
            match( Symbol.procedureRW );
            Token procId = scanner.getToken();
            match( Symbol.identifier );
            ProcedureDecl procDecl = new ProcedureDecl( procId );
            idTable.add( procDecl );
            idTable.openScope();

            if ( scanner.getSymbol() == Symbol.leftParen ) {
                procDecl.setFormalParams( parseFormalParameters() );
            }

            match( Symbol.isRW );
            procDecl.setInitialDecls( parseInitialDecls() );
            
            subprogramContext.beginSubprogramDecl( procDecl );
            procDecl.setStatementPart( parseStatementPart() );
            subprogramContext.endSubprogramDecl();
            idTable.closeScope();

            Token procId2 = scanner.getToken();
            match( Symbol.identifier );

            if ( !procId.getText().equals( procId2.getText() ) ) {
                throw error( procId2.getPosition(), "Procedure name mismatch." );
            }

            match( Symbol.semicolon );
            
            return procDecl;
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "procedureDecl" ) );
            return null;
        }
        
    }

    /**
     * 
     * functionDecl = "function" funcId ( formalParameters )? "return" typeName "is" initialDecls statementPart funcId ";" .
     */
    public FunctionDecl parseFunctionDecl() throws IOException {
        
        try {
            match( Symbol.functionRW );
            Token funcId = scanner.getToken();
            match( Symbol.identifier );
            FunctionDecl functionDecl = new FunctionDecl(funcId);
            idTable.add(functionDecl);
            idTable.openScope();
           
            if ( scanner.getSymbol() == Symbol.leftParen ) {
                functionDecl.setFormalParams( parseFormalParameters() );
            }
           
            match( Symbol.returnRW );
           
            functionDecl.setType( parseTypeName() );
           
            match( Symbol.isRW );
            functionDecl.setInitialDecls(parseInitialDecls() );
           
            subprogramContext.beginSubprogramDecl(functionDecl); // rever
            functionDecl.setStatementPart(parseStatementPart());
            subprogramContext.endSubprogramDecl();
           
            idTable.closeScope();
            Token procId2 = scanner.getToken();
            match( Symbol.identifier );
            if ( !funcId.getText().equals( procId2.getText() ) ) {
                throw error( procId2.getPosition(), "Function name mismatch." );
            }
            match( Symbol.semicolon );
           
            return functionDecl;
           
           
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "functionDecl" ) );
            return null;
        }

    }

    /**
     * 
     * formalParameters = "(" parameterDecl ( "," parameterDecl )* ")" .
     */
    public List<ParameterDecl> parseFormalParameters() throws IOException {
        
        try {
           
            List<ParameterDecl> parameterDecls = new ArrayList<>();

            match( Symbol.leftParen );

            parameterDecls.add(parseParameterDecl());

            while ( scanner.getSymbol() == Symbol.comma ) {
                matchCurrentSymbol();
                parameterDecls.add(parseParameterDecl());
            }

            match( Symbol.rightParen );

            return parameterDecls;
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "formalParameters" ) );
            return null;
        }
        
    }

    /**
     * 
     * parameterDecl = ( "var" )? paramId ":" typeName .
     */
    public ParameterDecl parseParameterDecl() throws IOException {
        
        try {
            Boolean isVar = false;
            if (scanner.getSymbol() == Symbol.varRW) {
                matchCurrentSymbol();
                isVar = true;
            }
            
            Token paramId = scanner.getToken();
            
            match(Symbol.identifier);
            match(Symbol.colon);
            
            Type type = parseTypeName();
            ParameterDecl pd = new ParameterDecl(paramId, type, isVar);
            idTable.add(pd);
            
            return pd;
        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("parameterDecl"));
            return null;
        }
       
    }

    /**
     * 
     * statementPart = "begin" statements "end" .
     */
    public StatementPart parseStatementPart() throws IOException {
        
        try {
            match( Symbol.beginRW );
            List<Statement> statements = parseStatements();
            match( Symbol.endRW );
            return new StatementPart( statements );
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "statementPart" ) );
            return null;
        }
        
    }

    /**
     * 
     * statements = ( statement )* .
     */
    public List<Statement> parseStatements() throws IOException {
        
        List<Statement> statements = new ArrayList<>();
        while (scanner.getSymbol().isStmtStarter()) {
            Statement s = parseStatement();
            statements.add(s);
        }
        
        return statements;

    }

    /**
     * 
     * statement = assignmentStmt | ifStmt | loopStmt | exitStmt | readStmt
     *           | writeStmt | writelnStmt | procedureCallStmt | returnStmt .
     */
    public Statement parseStatement() throws IOException {
        
        assert scanner.getSymbol().isStmtStarter() : "Invalid statement.";
               
        try {
            if ( scanner.getSymbol() == Symbol.exitRW ) {
                return parseExitStmt();
            } else if ( scanner.getSymbol() == Symbol.identifier ) {
                Declaration idType = idTable.get( scanner.getToken() );
                if ( idType == null ) {
                    String errorMsg = "Identifier \"" + scanner.getToken() +
                                      "\" has not been declared.";
                    throw error( scanner.getToken().getPosition(), errorMsg );
                
                } else if ( idType instanceof NamedDecl ) {
                    return parseAssignmentStmt();
                } else if ( idType instanceof ProcedureDecl ) {
                    return parseProcedureCallStmt();
                } else if ( idType instanceof ConstDecl ) {
                    String errorMsg = "Identifier \"" + scanner.getToken() +
                                      "\" cannot start a statement.";
                    throw error( scanner.getToken().getPosition(), errorMsg );
                }
            } else if ( scanner.getSymbol() == Symbol.ifRW ) {
                return parseIfStmt();
            } else if ( scanner.getSymbol() == Symbol.loopRW ) {
                return parseLoopStmt();
            } else if ( scanner.getSymbol() == Symbol.whileRW ) {
                return parseLoopStmt();
            } else if ( scanner.getSymbol() == Symbol.readRW ) {
                return parseReadStmt();
            } else if ( scanner.getSymbol() == Symbol.writeRW ) {
                return parseWriteStmt();
            } else if ( scanner.getSymbol() == Symbol.writelnRW ) {
                return parseWritelnStmt();
            } else if ( scanner.getSymbol() == Symbol.returnRW ) {
                return parseReturnStmt();
            } else {
                throw internalError( "Invalid statement." );
            }
       
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            scanner.advanceTo( Symbol.semicolon );
            recover( FOLLOW_SETS.get( "statement" ) );
            return null;
        }
       
        return null;
        
    }

    /**
     * 
     * assignmentStmt = variable ":=" expression ";" .
     */
    public AssignmentStmt parseAssignmentStmt() throws IOException {
        
        try {
            Variable variable = parseVariable();
            Position assignPos = scanner.getPosition();
          
           
            try {
                match( Symbol.assign );
            } catch ( ParserException e ) {
               
                if ( scanner.getSymbol() == Symbol.equals ) {
                    ErrorHandler.getInstance().reportError( e );
                    matchCurrentSymbol();  // tratar "=" como ":="
                                           // nesse contexto
                } else {
                    throw e;
                }
               
            }
           
            Expression expr = parseExpression();
            match( Symbol.semicolon );
           
           
            return new AssignmentStmt(variable, expr, assignPos);
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "assignmentStmt" ) );
            return null;
        }
        
    }

    /**
     * 
     * ifStmt = "if" booleanExpr "then" statements
     *          ( "elsif" booleanExpr "then" statements )*
     *          ( "else" statements )? "end" "if" ";" .
     */
    public IfStmt parseIfStmt() throws IOException {
        
        try {
           
            match( Symbol.ifRW );
            Expression exp = parseExpression();
             
            match( Symbol.thenRW );
            List<Statement> statements = parseStatements();
           
            List<ElsifPart> elsifs = new ArrayList<>();
           
            List<Statement> elses = new ArrayList<>();
           
            while ( scanner.getSymbol() == Symbol.elsifRW ) {
                match( Symbol.elsifRW );
                Expression elsifExpr = parseExpression();
                match( Symbol.thenRW );
                List<Statement> elsifStatements = parseStatements();
                elsifs.add(new ElsifPart(elsifExpr , elsifStatements));
            }
           
            if ( scanner.getSymbol() == Symbol.elseRW ) {
                match( Symbol.elseRW );
                elses = parseStatements();
               
            }
       
            match( Symbol.endRW );
            match( Symbol.ifRW );
            match( Symbol.semicolon );
            return new IfStmt(exp, statements, elsifs, elses);
          
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "ifStmt" ) );
            return null;
        }

    }

    /**
     * 
     * loopStmt = ( "while" booleanExpr )? "loop" statements "end" "loop" ";" .
     */
    public LoopStmt parseLoopStmt() throws IOException {
        
        try {
           
            Expression expr = null;
            List<Statement> statements = new ArrayList<>();
           
           
            if ( scanner.getSymbol() == Symbol.whileRW ) {
                matchCurrentSymbol();
                expr = parseExpression();
            }
            match( Symbol.loopRW );
           
            LoopStmt ls = new LoopStmt();
           
            ls.setWhileExpr(expr);
            loopContext.beginLoop(ls);
           
            statements = parseStatements();
           
            ls.setStatements(statements);
           
            loopContext.endLoop();
           
         
            match( Symbol.endRW );
            match( Symbol.loopRW );
            match( Symbol.semicolon );
           
            return ls;
           
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "loopStmt" ) );
            return null;
        }
        
    }

    /**
     * 
     * exitStmt = "exit" ( "when" booleanExpr )? ";" .
     */
    public ExitStmt parseExitStmt() throws IOException {        
        
        try {
            Position p = scanner.getPosition();
            match(Symbol.exitRW);
            Expression whenExpr = null;
            if (scanner.getSymbol() == Symbol.whenRW) {
                matchCurrentSymbol();
                whenExpr = parseExpression();
            }
            match(Symbol.semicolon);
            LoopStmt ls = loopContext.getLoopStmt();
            if (ls == null) {
                String errorMsg = "Exit statement is not nested within a loop.";
                throw error(p, errorMsg);
            }
            return new ExitStmt(whenExpr, ls);
        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("exitStmt"));
            return null;
        }
        
    }

    /**
     * 
     * readStmt = "read" variable ";" .
     */
    public ReadStmt parseReadStmt() throws IOException {
        
        try {
           
            match( Symbol.readRW );
            Variable v = parseVariableExpr();
            match( Symbol.semicolon );
           
            return new ReadStmt(v);
           
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "readStmt" ) );
            return null;
        }

        
    }

    /**
     * 
     * writeStmt = "write" expressions ";" .
     */
    public WriteStmt parseWriteStmt() throws IOException{
        
        try {
           
            List<Expression> expressions;
           
            match( Symbol.writeRW );
            expressions = parseExpressions();
            match( Symbol.semicolon );
           
            return new WriteStmt(expressions);
           
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "writeStmt" ) );
            return null;
        }
   
    }

    /**
     * 
     * expressions = expression ( "," expression )* .
     */
    public List<Expression> parseExpressions() throws IOException {
        
        List<Expression> expressions = new ArrayList<>();  
        expressions.add(parseExpression());
       
        while ( scanner.getSymbol() == Symbol.comma ) {
            matchCurrentSymbol();
            expressions.add(parseExpression());
        }

        return expressions;
        
    }

    /**
     * 
     * writelnStmt = "writeln" ( expressions )? ";" .
     */
    public WritelnStmt parseWritelnStmt() throws IOException {
        
        try {
            
            match( Symbol.writelnRW );

            List<Expression> expressions;
            if ( scanner.getSymbol().isExprStarter() ) {
                expressions = parseExpressions();
            } else {
                expressions = Collections.emptyList();
            }

            match( Symbol.semicolon );
            
            return new WritelnStmt( expressions );
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "writelnStmt" ) );
            return null;
        }
        
    }

    /**
     * 
     * procedureCallStmt = procId ( actualParameters )? ";" .
     */
    public ProcedureCallStmt parseProcedureCallStmt() throws IOException {
                    
        try {
           
            Token t = scanner.getToken();
            List<Expression> li = new ArrayList<>();
           
            match( Symbol.identifier );
           
            if ( scanner.getSymbol().isExprStarter() ) {
                li = parseActualParameters();
            }
           
            match( Symbol.semicolon );
           
            return new ProcedureCallStmt(t, li, (ProcedureDecl) idTable.get(t));
           
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "procedureCallStmt" ) );
            return null;
        }
        
    }

    /**
     * 
     * actualParameters = "(" expressions ")" .
     */
    public List<Expression> parseActualParameters() throws IOException {
        
        try {
           
            List<Expression> list;
           
            match( Symbol.leftParen );
            list = parseExpressions();
            match( Symbol.rightParen );
           
            return list;
           
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "actualParameters" ) );
            return null;
        }

    }

    /**
     * 
     * returnStmt = "return" ( expression )? ";" .
     */
    public ReturnStmt parseReturnStmt() throws IOException {
                     
        try {
            Expression expr = null;
            Position p = scanner.getPosition();
            match( Symbol.returnRW );
           
            if ( scanner.getSymbol().isExprStarter() ) {
                expr = parseExpression();
            }
           
            match( Symbol.semicolon );
           
           
            SubprogramDecl sc = subprogramContext.getSubprogramDecl();
            if (sc == null) {
                throw error(p, "Return statement is not nested within a subprogram.");
            }
            return new ReturnStmt(sc, expr, p);
           
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "returnStmt" ) );
            return null;
        }
           
    }

    /**
     * Analisa a regra gramatical abaixo:
     * 
     * variable = ( varId | paramId ) ( "[" expression "]" )* .
     * 
     * Esse método auxiliar provê uma lógica comum aos métodos parseVariable() e
     * parseNamedValue(). Esse método não lida com quaisquer exceções geradas
     * pelo parser (ParseException), lançando-as ao método chamador para que
     * possam ser manipuladas apropriadamente.
     *
     * @throws ParserException se a análise falhar.
     * @see #parseVariable()
     * @see #parseNamedValue()
     */
    public Variable parseVariableExpr() throws IOException, ParserException {
        
        Token idToken = scanner.getToken();
        match( Symbol.identifier );
        Declaration decl = idTable.get( idToken );
        
        if ( decl == null ) {
            
            String errorMsg = "Identifier \"" + idToken + 
                              "\" has not been declared.";
            throw error( idToken.getPosition(), errorMsg );
            
        } else if ( !( decl instanceof NamedDecl ) ) {
            
            String errorMsg = "Identifier \"" + idToken + 
                              "\" is not a variable.";
            throw error( idToken.getPosition(), errorMsg );
            
        }

        NamedDecl namedDecl = (NamedDecl) decl;
        List<Expression> indexExprs = new ArrayList<>();
        
        while ( scanner.getSymbol() == Symbol.leftBracket ) {
            matchCurrentSymbol();
            indexExprs.add( parseExpression() );
            match( Symbol.rightBracket );
        }
        
        return new Variable( namedDecl, idToken.getPosition(), indexExprs );
        
    }

    /**
     * 
     * variable = ( varId | paramId ) ( "[" expression "]" )* .
     */
    public Variable parseVariable() throws IOException {
        
        try {
            return parseVariableExpr();
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "variable" ) );
            return null;
        }
        
    }

    /**
     * 
     * expression = relation ( logicalOp relation )* .
     *  logicalOp = "and" | "or" .
     */
    public Expression parseExpression() throws IOException {
        
        Expression relation = parseRelation();
        Expression relation2 = null;
        Token operator = null;
        
        while ( scanner.getSymbol().isLogicalOperator() ) {
            operator = scanner.getToken();
            matchCurrentSymbol();
            relation2 = parseRelation();
            relation = new LogicalExpr( relation, operator, relation2 );
        }

        return relation;
        
    }

    /**
     * 
     *     relation = simpleExpr ( relationalOp simpleExpr )? .
     * relationalOp = "=" | "!=" | "<" | "<=" | ">" | ">=" .
     */
    public Expression parseRelation() throws IOException {
        
        Expression expr = parseSimpleExpr();
        if (scanner.getSymbol().isRelationalOperator()) {
            Token operator = scanner.getToken();
            matchCurrentSymbol();
            Expression expr2 = parseSimpleExpr();
            expr = new RelationalExpr(expr, operator, expr2);
        }
       
        return expr;
        
    }

    /**
     * 
     * simpleExpr = ( addingOp )? term ( addingOp term )* .
     *   addingOp = "+" | "-" .
     */
    public Expression parseSimpleExpr() throws IOException {
        
        Token op1 = null;
        
        if (scanner.getSymbol().isAddingOperator()) {
            op1 = scanner.getToken();
            matchCurrentSymbol();
        }
        Expression term = parseTerm();
        if (op1 != null) {
            term = new NegationExpr(op1, term);
        }
        while (scanner.getSymbol().isAddingOperator()) {
            Token operator = scanner.getToken();
            matchCurrentSymbol();
            Expression term2 = parseTerm();
            term = new AddingExpr(term, operator, term2);
        }

         return term;
        
    }

    /**
     * 
     *          term = factor ( multiplyingOp factor )* .
     * multiplyingOp = "*" | "/" | "mod" .
     */
    public Expression parseTerm() throws IOException {
        
        Expression factor = parseFactor();
        while ( scanner.getSymbol().isMultiplyingOperator() ) {
            Token operator = scanner.getToken();
            matchCurrentSymbol();
            Expression factor2 = parseFactor();
            factor = new MultiplyingExpr(factor, operator, factor2);
        }
        
        return factor;
        
    }

    /**
     * 
     * factor = "not" factor | constValue | namedValue | functionCall
     *        | "(" expression ")" .
     */
    public Expression parseFactor() throws IOException {
        
        try {
            
            Expression expr;
            
            if ( scanner.getSymbol() == Symbol.notRW ) {
                
                Token operator = scanner.getToken();
                matchCurrentSymbol();
                Expression factorExpr = parseFactor();
                expr = new NotExpr( operator, factorExpr );
                
            } else if ( scanner.getSymbol().isLiteral() ) {
                
                expr = parseConstValue();
                
            } else if ( scanner.getSymbol() == Symbol.identifier ) {
                
                Token idToken = scanner.getToken();
                Declaration decl = idTable.get( idToken );

                if ( decl != null ) {
                    if ( decl instanceof ConstDecl ) {
                        expr = parseConstValue();
                    } else if ( decl instanceof NamedDecl ) {
                        expr = parseNamedValue();
                    } else if ( decl instanceof FunctionDecl ) {
                        expr = parseFunctionCall();
                    } else {
                        throw error( "Identifier \"" + scanner.getToken() +
                                     "\" is not valid as an expression." );
                    }
                } else {
                    throw error( "Identifier \"" + scanner.getToken() +
                                 "\" has not been declared." );
                }
                
            } else if ( scanner.getSymbol() == Symbol.leftParen ) {
                matchCurrentSymbol();
                expr = parseExpression();
                match( Symbol.rightParen );
            } else {
                throw error( "Invalid expression." );
            }
            
            return expr;
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "factor" ) );
            return null;
        }
        
    }

    /**
     * 
     * constValue = literal | constId .
     */
    public ConstValue parseConstValue() throws IOException {
        
        try {
            Token t;
            if (scanner.getSymbol().isLiteral()) {
                t = parseLiteral();
                ConstValue cv = new ConstValue(t);
                return cv;
            } else if (scanner.getSymbol() == Symbol.identifier) {
                t = scanner.getToken();
               
                matchCurrentSymbol();
               
                ConstDecl d = (ConstDecl) idTable.get(t);
               
                ConstValue cv = new ConstValue(t, d);
               
                return cv;
            } else {
                throw error("Invalid constant.");
            }
        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("constValue"));
            return null;
        }
     
    }

    /**
     * 
     * namedValue = variable .
     */
    public NamedValue parseNamedValue() throws IOException {
        
        try {
            Variable variableExpr = parseVariableExpr();
            return new NamedValue( variableExpr );
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "namedValue" ) );
            return null;
        }
        
    }

    /**
     * 
     * functionCall = funcId ( actualParameters )? .
     */
    public FunctionCall parseFunctionCall() throws IOException {
        
        try {
            Token funcId = scanner.getToken();
            List<Expression> list = new ArrayList<>();
            match( Symbol.identifier );
           
            if ( scanner.getSymbol().isExprStarter() ) {
                list = parseActualParameters();
            }
           
            return new FunctionCall(funcId, list, (FunctionDecl) idTable.get(funcId));
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "functionCall" ) );
            return null;
        }

        
    }

    
    
    /***************************************************************************
     *                     Métodos utilitários de análise                      *
     **************************************************************************/
                            // não precisa mexer nesses
    
    
    /**
     * Verifica se o símbolo atual do scanner é o símbolo esperado. Se for,
     * avança o scanner. Caso contrário, lança uma ParserException.
     */
    private void match( Symbol expectedSymbol ) throws IOException, ParserException {
        
        if ( scanner.getSymbol() == expectedSymbol ) {
            scanner.advance();
        } else {
            String errorMsg = "Expecting \"" + expectedSymbol + 
                              "\" but found \"" + scanner.getToken() + 
                              "\" instead.";
            throw error( errorMsg );
        }
        
    }

    /**
     * Avança o scanner. Esse método representa uma correspondência
     * incondicional com o símbolo atual do scanner.
     */
    private void matchCurrentSymbol() throws IOException {
        scanner.advance();
    }

    /**
     * Avança o scanner até que o símbolo atual seja um dos símbolos 
     * especificados no array de símbolos seguidores (follow).
     */
    private void recover( Symbol[] followers ) throws IOException {
        scanner.advanceTo( followers );
    }

    /**
     * Cria uma ParserException com a mensagem especificada e a posição corrente
     * do scanner.
     */
    private ParserException error( String errMsg ) {
        return new ParserException( scanner.getPosition(), errMsg );
    }

    /**
     * Cria uma ParserException especificando a posição atual do scanner e a
     * mensagem do erro.
     */
    private ParserException error( Position errPos, String errMsg ) {
        return new ParserException( errPos, errMsg );
    }

    /**
     * Cria uma InternalCompilerException especificando a posição atual do
     * scanner e a mensagem do erro.
     */
    private InternalCompilerException internalError( String message ) {
        return new InternalCompilerException( scanner.getPosition(), message );
    }
    
}