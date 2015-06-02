# Trabalho3POO
Objetivo:
  O objetivo deste trabalho é de simular um sistema de biblioteca que possui um cadastro de livros, cadastro de usuários do 
  sistema e uma tabela de emprestimos.
  
Funcionamento:
  O programa possui um menu que é impresso na tela, nesta etapa o sistema espera algum dado de entrada passada pelo usuario
(algumas das opções de escolha do menu), assim que o dado é inserido a informação vindo do teclado é comparada com algumas 
das opções iniciais do menu e o programa a partir desta comparação executa alguma parte do código.

Opções:
  Cadastrar usuario:
    Nesta etapa criamos um objeto do tipo usuário, digitamos informações com nome e sua classificação (aluno, professor ou 
    comunidade). Ao finalizar o cadastro, esse novo objeto é enviado para uma lista de objetos do tipo usuario onde fica 
    armazenado. 
  
  Cadastrar livros:
    Nesta etapa criamos um objeto do tipo livro, digitamos informações com nome e o tipo de livro (texto ou geral). Ao finalizar
    o cadastro, esse novo objeto é enviado para uma lista de objetos do tipo livro onde fica armazenado.
    
  Imprimir usuario e livros:
    Nesta etapa, a lista de objetos é percorrida imprimindo o nome de cada um deles.
    
  Emprestimo:
    Nesta etapa, informamos atraves do teclado o nome do usuario que deseja pegar um livro emprestado. O programa percorre o
    lista de usuarios para verificar se o nome enviado esta cadastrado, caso esteja, o programa pergunta o nome do livro que
    o usuario deseja.
    Assim que o nome de usuario e do livro são validados, um arquivo CSV é criado e todas as informações com relação ao 
    emprestimosão gravadas no arquivo.
