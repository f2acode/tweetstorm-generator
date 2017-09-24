# The challenge

Do you know what a **Tweetstorm** is?

It's a way to bypass Twitter's blessed 140 chars limit.

It allows you to break down a larger corpus of text into tweets and post them in quick
succession, forming a cohesive whole.

Since Twitter can barely count (and monotonically increasing numbers is hard!), the final order
in which users will see the sequence might not be the one you posted. Or someone retweeted it, losing context.

In order to keep some sense of narrative and connection you prefix each piece of the corpus
with the part that it represents (1/4, then 2/4 then 3/4 then 4/4).

**The assignment: Create a program that receives a text or arbitrary length and creates a
tweetstorm with it.**

Freedom is overrated. Here our constrains:

1. Each tweet can't be over 140 characters,

2. Each tweet must be prefixed with the current index / total count.

3. We'll call your program from a Unix shell, like /opt/hiring/yourname/tweetstormgenerator, with the text corpus passed as a parameter

4. You can choose any language you would like, but stick to its built in library (if actually think you need a third-party lib to achieve this, we're curious to know what that would be). Please don't choose brainfuck, we're afraid we might actually enjoy reading it.

# Execução a aplicação

Um breve tutorial para realizar a compilação e execução da aplicação:

Compilar com o seguinte comando:

`javac -cp twitter4j-core-4.0.4.jar tweetstormGenerator.java`

E executar com o seguinte comando:

`java -cp twitter4j-core-4.0.4.jar:. tweetstormGenerator`

Obs:. O arquivo `.jar` deve estar na mesma pasta do arquivo java.

# Melhorias:

* Remover limite de 12.000 caracteres no texto, devido à formatação para inserção do índice antes da mensagem.
 
* Tratar quebra de linha no texto que é tida como `Enter` para execução, e consequentemente gera execução incorreta.

* Verificar tweets recentes para evitar negação de tweet (tweets duplicados são recusados de serem postados pela API).

* Melhorar quebra de texto, mantendo uma melhor leitura (evitar quebrar no meio da frase, preferindo pontos para quebra de tweet)

* Tratar textos com parênteses, ponto e vírgula e aspas quando passados como parâmetro, que quebram o na execução por serem tidos como comandos reservados.

* Criar interface amigável.

# Mantendo o código

#### Sem comentários
O código foi dividido em métodos pequenos com funções específicas, e nomes **autoexplicativos**, o que por si só pode abolir a necessidade de comentários. Claro que isso pode depender da equipe, e estilo de desenvolvimento e pode ser adaptado, mas aderi à essa prática para um **código mais limpo**.

#### Flexível e sustentável
É possível inserir novas funcionalidades, sem a necessidade de alteração nas já existentes.
Além de ser facilmente melhorado, corrigindo possíveis falhas sem a necessidade de grande reescrita.

#### Lib
Foi utilizada a lib [Twitter4J](http://twitter4j.org/en/index.html) para realizar a conexão com o Twitter, assim como a utilização dos métodos HTTP.