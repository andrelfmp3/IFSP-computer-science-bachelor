package edu.citadel.cprl;

import edu.citadel.compiler.ErrorHandler;
import edu.citadel.compiler.Position;
import edu.citadel.compiler.ScannerException;
import edu.citadel.compiler.Source;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Executa a análise léxica da linguagem de programação CPRL.
 *
 * Versão corrente.
 */
public class Scanner {

    // leitor de código, que percorre o arquivo
    // caractere por caractere
    private Source source;

    // símbolo lido do momento (tipo do token)
    private Symbol symbol;

    // posição do token
    private Position position;

    // texto do token
    private String text;

    // buffer de escaneamento para obtenção texto que estiver sendo processado
    private StringBuilder scanBuffer;

    // suporte para o Passo 02, um mapa que conterá os símbolos associados ao
    // seus labels
    private Map<String, Symbol> symbolMap;

    /**
     * Inicializa o Scanner com o source associado e avança para o primeiro
     * token.
     */
    public Scanner(Source source) throws IOException {

        this.source = source;
        this.scanBuffer = new StringBuilder(100);

        // preparando o mapa de símbolos
        this.symbolMap = new TreeMap<>();
        for (Symbol s : Symbol.values()) {
            symbolMap.put(s.toString(), s);
        }

        // avança para o primeiro token
        advance();

    }

    /**
     * Avança ao próximo token do arquivo de código.
     */
    public void advance() throws IOException {

        try {

            // descarta os espaços em branco
            skipWhiteSpace();

            // obtém a posição do início do próximo token
            position = source.getCharPosition();

            // ainda não há texto
            text = null;

            // ATENÇÃO: REMOVA OU COMENTE A LINHA ABAIXO PARA REALIZAR
            // A SUA IMPLEMENTAÇÃO!!!
            //source.advance();
            // se o caractere atual for a marcação de fim de arquivo
            if (source.getChar() == Source.EOF) {

                // configura o símbolo, mas não avança, pois não há mais
                //o que processar
                symbol = Symbol.EOF;

                // se o caractere atual é uma letra
            } else if (Character.isLetter((char) source.getChar())) {

                // realiza o escaneamento de identificadores
                // note que neste momento da análise léxica, quaisquer cadeias
                // de um ou mais caracteres serão lidas como identificadores
                // e serão classificadas depois do escaneamento
                // este é o passo 02 da sua implementação, onde você deve
                // implementar os métodos:
                //     (a) scanIdentifier, responsável em ler um identificador
                //     (b) getIdentifierSymbol, responsável em identificar qual
                //         o símbolo do identificador
                //
                // Obs: você não precisa mexer aqui!
                // obtém a string do identificador (ainda não se sabe se é um
                // identificador de fato)
                String idString = scanIdentifier();

                // obtém qual o símbolo correspondente, aqui é a decisão de
                // qual é o significado do que foi escaneado
                symbol = getIdentifierSymbol(idString);

                // se for um símbolo de identificador de fato
                if (symbol == Symbol.identifier) {
                    // o texto do token é a própria identificação
                    text = idString;
                }

                // se o caractere atual é um dígito
            } else if (Character.isDigit((char) source.getChar())) {

                // já se sabe que é um literal de inteiro
                symbol = Symbol.intLiteral;

                // faz o escaneamento do literal de inteiro
                text = scanIntegerLiteral();

                // caso contrário, processa-se todos os outros tipos de
                // caracteres
            } else {

                switch ((char) source.getChar()) {

                    // este é o passo 01 da sua implementação, onde você deve
                    // identificar se o que será processado é um comentário de
                    // uma linha. note que como um comentário inicia com o
                    // caractere barra (/), o analisador léxico precisa
                    // diferenciar um comentário de um operador de divisão                   
                    // para o descarte do comentário, você deve implementar o
                    // método skipComment (pular comentário) e usá-lo. lembre-se
                    // que o comentário é irrelevante de depos de escaneado,
                    // deve ser descartado.
                    // <editor-fold defaultstate="collapsed" desc="Implementação do Passo 01">
                    // sua implementação aqui
                    // </editor-fold>
                    case '/':

                        source.advance();

                        if ((char) source.getChar() == '/') {
                            skipComment();
                            advance();
                            //symbol = Symbol.unknown;//o que fazer
                        } else {
                            symbol = Symbol.divide;
                        }

                        break;

                    // este é o passo 03 da sua implementação, onde deve-se
                    // escanear todos os tokens que representam operadores,
                    // delimitadores etc. alguns exemplos seguem abaixo:
                    // exemplo 1: adição
                    case '+': // se é um caractere +

                        // sabe-se que é um símbolo do tipo plus
                        symbol = Symbol.plus;

                        // avança o leitor em um caractere
                        source.advance();

                        break;

                    // exemplo 2: maior e maior ou igual
                    case '>': // Se o caractere for '>'
                        // Pode ser que seja um maior ou igual, então
                        // avança mais um caractere para ver se é esse o caso
                        source.advance();

                        // Verifica se o próximo caractere é '='
                        if ((char) source.getChar() == '=') {
                            symbol = Symbol.greaterOrEqual; // Define o operador como >=
                            source.advance(); // Avança após o '='
                        } else {
                            symbol = Symbol.greaterThan; // Define o operador como >
                        }
                        break;

                    case '-': // Se o caractere for '-'
                        symbol = Symbol.minus;
                        source.advance();
                        break;

                    case '*': // Se o caractere for ''
                        symbol = Symbol.times;
                        source.advance();
                        break;

                    case '<': // Se o caractere for '<'
                        // Avança para o próximo caractere
                        source.advance();

                        // Verifica se o próximo caractere é '='
                        if ((char) source.getChar() == '=') {
                            symbol = Symbol.lessOrEqual; // Define o operador como <=
                            source.advance(); // Avança após o '='
                        } else {
                            symbol = Symbol.lessThan; // Define o operador como <
                        }
                        break;

                    case '!': // Se o caractere for '!'
                        // Avança para o próximo caractere
                        source.advance();

                        // Verifica se o próximo caractere é '='
                        if ((char) source.getChar() == '=') {
                            symbol = Symbol.notEqual; // Define o operador como !=
                            source.advance(); // Avança após o '='
                        } else {

                            //PAROU DE DAR ERROOOO
                            String errorMsg = "Invalid character '" + ("!") + "\'";
                            throw error(errorMsg);

                        }
                        break;

                    case '=':

                        symbol = Symbol.equals;

                        source.advance();
                        break;

                    case '(':
                        symbol = Symbol.leftParen;

                        source.advance();
                        break;

                    case ')':

                        symbol = Symbol.rightParen;

                        source.advance();
                        break;

                    case ':':

                        source.advance();

                        // Verifica se o próximo caractere é '='
                        if ((char) source.getChar() == '=') {
                            symbol = Symbol.assign; // Define o operador como >=
                            source.advance(); // Avança após o '='
                        } else {
                            symbol = Symbol.colon; // Define o operador como >
                        }
                        break;

                    case '[':
                        symbol = Symbol.leftBracket;

                        source.advance();
                        break;
                    case ']':
                        symbol = Symbol.rightBracket;

                        source.advance();
                        break;

                    case ',':
                        symbol = Symbol.comma;

                        source.advance();
                        break;

                    case ';':
                        symbol = Symbol.semicolon;

                        source.advance();
                        break;

                    case '.':
                        symbol = Symbol.dot;

                        source.advance();
                        break;

                    // </editor-fold>
                    // este é o passo 04 da sua implementação, onde deve-se
                    // escanear os literais de caracteres ('a', 'b' etc) e 
                    // strings ("abc", "", "x" etc).
                    // o método scanCharLiteral já está pronto e o método
                    // scanStringLiteral deve ser implementado. para a
                    // implementação do escaneamento de strings, use como base
                    // o escaneamento de caracteres
                    // <editor-fold defaultstate="collapsed" desc="Implementação do Passo 04">
                    // sua implementação aqui
                    // </editor-fold>
                    //aspa simples( inicio de caractere)
                    case '\'':
                        //marca commo token do tipo char
                        symbol = Symbol.charLiteral;
                        // chama o metodo que le o conteudo
                        text = scanCharLiteral();

                        break;

                    case '\"':

                        symbol = Symbol.stringLiteral;

                        text = scanStringLiteral();

                        break;

                    default:
                        char c = (char) source.getChar();
                        Position pos = source.getCharPosition();
                        //muitas gambiarras 
                        if (c == '!') {
                            String errorMsg = "Invalid character '" + c + "'";
                            source.advance();
                            throw new ScannerException(pos, errorMsg);
                        } else if (c == '?') {
                            String errorMsg = "Invalid character '" + c + "'";
                            source.advance();
                            throw new ScannerException(pos, errorMsg);
                        } else if (c == '#') {
                            String errorMsg = "Invalid character '" + c + "'";
                            source.advance();
                            throw new ScannerException(pos, errorMsg);

                        } else if (c == '@') {

                            String errorMsg = "Invalid character '" + c + "'";
                            source.advance();
                            throw new ScannerException(pos, errorMsg);

                        } else if (!Character.isWhitespace(c)) {
                            String errorMsg = "Invalid character '" + c + "'";
                            source.advance();
                            throw new ScannerException(pos, errorMsg);
                        }

                        source.advance();
                        advance();
                        return;
                }

            }

        } catch (ScannerException e) {

            // reporta o erro.
            // dentro do ErrorHandler foi mudada a forma de envio para usar
            // o stream de saída padrão da JVM, permitindo que nos testes
            // que vocês farão, as mensagens de erro também sejam verificadas
            // de modo a detectar a integridade do que foi implementado.
            ErrorHandler.getInstance().reportError(e);

            // configura o token como EOF ou unknown (desconhecido)
            symbol = source.getChar() == Source.EOF ? Symbol.EOF : Symbol.unknown;

        }

    }

    /**
     * Pula um comentário.
     *
     * Essa é a implementação do método skipComment, parte do passo 01 da sua
     * solução.
     *
     * Dica: Pode ser implementado de forma iterativa ou recursiva
     */
    private void skipComment() throws ScannerException, IOException {

        // Feito
        skipToEndOfLine();

    }

    /**
     * Escaneia caracteres no arquivo de código buscando por um identificador
     * válido usando a regra léxica:
     *
     * identifier = letter ( letter | digit )* .
     *
     *
     * Essa é a implementação do método scanIdentifier, parte do passo 02 da sua
     * solução.
     *
     * Dica: confira a implementação do método scanIntegerLiteral!
     *
     * @return a string de letras e dígitos do identificador.
     */
    private String scanIdentifier() throws IOException {
        //feito

        assert Character.isLetter((char) source.getChar()) :
                "scanIdentifier(): check identifier start for invalid character at position "
                + getPosition();

        clearScanBuffer();

        do {
            scanBuffer.append((char) source.getChar());
            source.advance();
        } while (Character.isLetterOrDigit((char) source.getChar()));

        return scanBuffer.toString();
    }

    /**
     * Retorna um símbolo associado à um identificador, por exemplo, Symbol.ifRW
     * para a palavra-chave if, Symbol.plus para o operador etc.
     *
     *
     * Essa é a implementação do método getIdentifierSymbol, parte do passo 02
     * da sua solução.
     *
     * Dica: utilize o mapa symbolMap para obter o símbolo correto!
     *
     * @return o símbolo associado ao identificador passado.
     */
    private Symbol getIdentifierSymbol(String idString) {

        Symbol symbol = symbolMap.get(idString);

        if (symbol != null) {
            return symbol;
        } else {

            return Symbol.identifier;

        }
    }

    /**
     * Escaneia os caracteres no arquivo de código buscando um literal de
     * String. Caracteres com escape não são convertidos, ou seja, '\t' não deve
     * ser convertido para o caractere de tabulação, pois o assembler cuidará
     * disso. Assuma que source.getChar() é a aspa dupla de abertura do literal
     * de String.
     *
     *
     * Essa é a implementação do método scanStringLiteral, parte do passo 04 da
     * sua solução.
     *
     * Dica: utilize o a implementação do método scanCharLiteral para ter uma
     * ideia de como deve proceder!
     *
     * @return a String do literal de String, incluindo as aspas duplas de
     * abertura e fechamento VER AQUI
     */
    private String scanStringLiteral() throws ScannerException, IOException {
        // assume que source.getChar() são as aspas duplas de abertura do
        // literal de String.
        assert (char) source.getChar() == '\"' :
                "scanStringLiteral(): check for opening double quote (\") at position "
                + getPosition() + ".";

        String errorMsg = "Invalid String literal.";
        clearScanBuffer();
        scanBuffer.append('\"');
        source.advance();

        while (true) {
            checkEOF();

            char c = (char) source.getChar();

            if (c == '\"') {
                scanBuffer.append('\"');
                source.advance();
                break;
            }

            checkGraphicChar(c);

            if (c == '\\') {

                scanBuffer.append(scanEscapedChar());

            } else {

                scanBuffer.append(c);
                source.advance();
            }

        }

        return scanBuffer.toString();

    }

    /**
     * Escaneia os caracteres no arquivo de código buscando um literal de Char.
     * Caracteres com escape não são convertidos, ou seja, '\t' não deve ser
     * convertido para o caractere de tabulação, pois o assembler cuidará disso.
     * Assuma que source.getChar() é a aspa simples de abertura do literal de
     * Char.
     *
     * @return a String do literal de Char, incluindo a aspa simples de abertura
     * e fechamento
     */
    private String scanCharLiteral() throws ScannerException, IOException {

        // assume que source.getChar() é a aspa simples de abertura
        // do literal de Char.
        assert (char) source.getChar() == '\'' :
                "scanCharLiteral(): check for opening quote (\') at position "
                + getPosition() + ".";

        String errorMsg = "Invalid Char literal.";
        clearScanBuffer();

        // insere a aspa simples de abertura
        char c = (char) source.getChar();
        scanBuffer.append(c);
        source.advance();

        // verifica se é um caractere gráfico
        checkGraphicChar(source.getChar());
        c = (char) source.getChar();

        // é de escape?
        if (c == '\\') {

            scanBuffer.append(scanEscapedChar());

            // ou '' (vazio) or ''', ambos inválidos!
        } else if (c == '\'') {

            source.advance();
            c = (char) source.getChar();

            // três aspas simples seguidas em uma linha
            if (c == '\'') {
                source.advance();
            }

            throw error(errorMsg);

        } else {
            scanBuffer.append(c);
            source.advance();
        }

        // c deverá conter a aspa simples de fechamento
        c = (char) source.getChar();
        checkGraphicChar(c);

        // é a aspa dupla de fechamento?
        if (c == '\'') {

            scanBuffer.append(c);   // adiciona a aspa simples de fechamento
            source.advance();

            // não é, faltou fechar... erro!!!
        } else {
            throw error(errorMsg);
        }

        return scanBuffer.toString();

    }

    /**
     * Escaneia caracteres no arquivo de código buscando por literais de
     * inteiros válidos. Assume que source.getChar() é o primeiro dígito do
     * literal de inteiros.
     *
     * @return a string com os dígitos do literal de inteiro. DANDO ERRO
     */
    private String scanIntegerLiteral() throws ScannerException, IOException {

        // assume que source.getChar() é o primeiro dígito do literal de
        // inteiros.
        assert Character.isDigit((char) source.getChar()) :
                "scanIntegerLiteral(): check integer literal start for digit at position "
                + getPosition();

        clearScanBuffer();

        do {
            scanBuffer.append((char) source.getChar());
            source.advance();
        } while (Character.isDigit((char) source.getChar()));

        return scanBuffer.toString();
    }

    /**
     * Escaneia os caracteres do arquivo de código procurando por caracteres de
     * escape, ou seja, um caractere precedido por uma contrabarra. Esse método
     * busca pelos caracteres de escape \b, \t, \n, \f, \r, \", \', e \\. Se o
     * caractere após a contrabassa for qualquer coisa que não seja esses
     * caracteres listados, então uma exceção será lançada. Note que a sequencia
     * que contém o caractere de escape é retornada sem nenhuma modificação, ou
     * seja, \t retorna "\t", não o caractere de tabulação. Assuma que
     * source.getChar() é a contrabarra (\) do caractere de escape.
     *
     * @return o caractere de escape, sem modificação.
     */
    private String scanEscapedChar() throws ScannerException, IOException {

        // assume que source.getChar() é a contrabarra (\) do caractere de
        // escape.
        assert (char) source.getChar() == '\\' :
                "Check for escape character ('\\') at position " + getPosition() + ".";

        // precisa salvar a posição atual caso haja necessidade de reportar erro
        Position backslashPosition = source.getCharPosition();

        source.advance();
        checkGraphicChar(source.getChar());
        char c = (char) source.getChar();

        // posiciona source no caractere seguinte à contrabassa
        source.advance();

        switch (c) {

            case 'b':
                return "\\b";    // backspace
            case 't':
                return "\\t";    // tab
            case 'n':
                return "\\n";    // linefeed (a.k.a. newline) (nova linha)
            case 'f':
                return "\\f";    // form feed (alimentador de formulário)
            case 'r':
                return "\\r";    // carriage return (retorno de carro)
            case '\"':
                return "\\\"";   // double quote (aspas duplas)
            case '\'':
                return "\\\'";   // single quote (aspas simples)
            case '\\':
                return "\\\\";   // backslash (contrabarra)

            // reporta erro, mas retorna a string inválida
            default:
                String errMessage = "Illegal escape character.";
                ScannerException ex = new ScannerException(backslashPosition, errMessage);
                ErrorHandler.getInstance().reportError(ex);
                return "\\" + c;
        }

    }

    /**
     * Descarta espaços em branco
     */
    private void skipWhiteSpace() throws IOException {
        while (Character.isWhitespace((char) source.getChar())) {
            source.advance();
        }
    }

    /**
     * Avança os caracteres de source até o fim da linha
     */
    private void skipToEndOfLine() throws ScannerException, IOException {
        while ((char) source.getChar() != '\n') {
            source.advance();
            checkEOF();
        }
    }

    /**
     * Verifica se o inteiro passao representa um caractere gráfico no Unicode
     * Basic Multilingual Plane (BMP).
     *
     * @throws ScannerException se o inteiro não representar um caractere
     * gráfico BMP.
     */
    private void checkGraphicChar(int n) throws ScannerException {

        if (n == Source.EOF) {
            throw error("End of file reached before closing quote for Char or String literal.");
        } else if (n > 0xffff) {
            throw error("Character not in Unicode Basic Multilingual Pane (BMP)");
        } else {

            char c = (char) n;

            // verificação especial para fim de linhaspecial check for end of line
            if (c == '\r' || c == '\n') {

                throw error("Char and String literals can not extend past end of line.");

                // não permite caracteres de controle ISO :P :P :P :P
            } else if (Character.isISOControl(c)) {

                throw new ScannerException(source.getCharPosition(),
                        "Control characters not allowed in Char or String literal.");

            }

        }

    }

    /**
     * Retorna uma ScannerException com a mensagem de erro especificada.
     */
    private ScannerException error(String errorMsg) {
        return new ScannerException(getPosition(), errorMsg);
    }

    /**
     * Usado para verificar pela marcação de fim de arquivo no meio do processo
     * de escaneamento de tokens que requerem caracteres de fechamento, como
     * strins e comentários
     *
     * @throws ScannerException se source estiver no fim do arquivo.
     */
    private void checkEOF() throws ScannerException {
        if (source.getChar() == Source.EOF) {
            throw new ScannerException(getPosition(), "Unexpected end of file");
        }
    }

    /**
     * Avança até que o símbolo do arquivo de código case com o símbolo
     * especificado no parâmetro ou até o fim do arquivo ser alcançado.
     */
    public void advanceTo(Symbol symbol) throws IOException {
        while (true) {
            if (getSymbol() == symbol || source.getChar() == Source.EOF) {
                return;
            } else {
                advance();
            }
        }
    }

    /**
     * Avança até que o símbolo do arquivo de código case com algum símbolo
     * contido no array especificado no parâmetro ou até o fim do arquivo ser
     * alcançado.
     */
    public void advanceTo(Symbol[] symbols) throws IOException {
        while (true) {
            if (search(symbols, symbol) >= 0 || source.getChar() == Source.EOF) {
                return;
            } else {
                advance();
            }
        }
    }

    /**
     * Executa uma busca linear em um array de símbolos por um valor.
     *
     * @return o índice em que o valor foi encontrado, caso contrário -1
     */
    private int search(Symbol[] symbols, Symbol value) {
        for (int i = 0; i < symbols.length; ++i) {
            if (symbols[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Limpa o buffer de escaneamento, ou seja, faz com que fique vazio.
     */
    private void clearScanBuffer() {
        scanBuffer.delete(0, scanBuffer.length());
    }

    /**
     * Retorna uma cópia do token atual contido no arquivo de código.
     */
    public Token getToken() {
        return new Token(symbol, position, text);
    }

    /**
     * Retorna a referência do símbolo atual contido no arquivo de código.
     */
    public Symbol getSymbol() {
        return symbol;
    }

    /**
     * Retorna a referência da posição do símbolo atual contido no arquivo de
     * código.
     */
    public Position getPosition() {
        return position;
    }

}