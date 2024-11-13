# Liste o CNPJ, razão social da entidade, 
# setor e atuação em ordem alfabética de setor, 
# atuação e razão social
SELECT Entidade.CNPJ_CPF, Entidade.RazaoSocial, Setor.NomeSetor, Atuacao.NomeAtuacao
FROM Entidade
INNER JOIN Atuacao ON Atuacao.CodAtuacao = Entidade.fkCodAtuacao
INNER JOIN Setor ON Setor.CodSetor = Atuacao.fkCodSetor
ORDER BY Setor.NomeSetor, Atuacao.NomeAtuacao, Entidade.RazaoSocial;

# Liste todos os dados dos eventos e sua localização 
# completa, inclusive com cidade e estado
SELECT Evento.*, LocalEvento.*, Cidade.*, Estado.*
FROM Evento
INNER JOIN LocalEvento ON LocalEvento.CodLocal = Evento.fkCodLocal
INNER JOIN Cidade ON Cidade.CodCidade = LocalEvento.fkCodCidade
INNER JOIN Estado ON Estado.SiglaUF = Cidade.fkSiglaUF;

# Liste a razão social da entidade, nome do 
#colaborador e suas redes sociais e telefones da 
#entidade em ordem de razão social e colaborador
SELECT Entidade.RazaoSocial, Colaborador.NomeContato, RedesSociaisColaborador.Usuario, TelefonesEntidade.DDD, TelefonesEntidade.Telefone
FROM Entidade
INNER JOIN Colaborador ON Colaborador.fkCNPJ_CPF = Entidade.CNPJ_CPF
INNER JOIN RedesSociaisColaborador ON RedesSociaisColaborador.fkCodContato = Colaborador.CodContato
INNER JOIN TelefonesEntidade ON TelefonesEntidade.fkCNPJ_CPF = Entidade.CNPJ_CPF;

# Liste o nome do colaborador e suas áreas de 
#interesse em ordem de nome e interesse
SELECT Colaborador.NomeContato, Interesse.NomeInteresse
FROM Colaborador
INNER JOIN InteressesContato ON InteressesContato.fkCodContato = Colaborador.CodContato
INNER JOIN Interesse ON Interesse.CodInteresse = InteressesContato.fkCodInteresse
ORDER BY Colaborador.NomeContato, Interesse.NomeInteresse;

# Liste o nome do colaborador e nome do evento que 
# participou cuja classificação do evento seja a 
# mesma do colaborador.
SELECT Colaborador.NomeContato, Evento.NomeEvento
FROM Colaborador
INNER JOIN ParticipacaoEvento ON ParticipacaoEvento.fkCodContato = Colaborador.CodContato
INNER JOIN Evento ON Evento.CodEvento = ParticipacaoEvento.fkCodEvento
WHERE Colaborador.fkCodClassificacao = Evento.fkCodClassificacao;

