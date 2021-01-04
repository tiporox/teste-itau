# teste-itau



# Pré-requisitos para executar o projeto localmente:
 - JDK Java 11+ instalado.
 - Maven 3+ instalado;
 - Plugin IDE lombok


# Executando o projeto:

Instalando lombok:

```sh
https://projectlombok.org/setup/eclipse
```
Clonando o projeto do repositório:

```sh
$ git clone https://github.com/tiporox/teste-itau.git
```
Navegando até a pasta do projeto:

```sh
$ cd ./teste-itau
```
Executando o projeto:

```sh
$ mvn spring-boot:run
```

Consumindo a api:

```sh
$ curl --location --request POST 'localhost:8080/v1/passwords/policies/validate' \
--header 'Content-Type: application/json' \
--data-raw '{
    "password": "AbTp9!fok"
}'
```
Response:

```sh
$ {"data":{"errors":[],"valid":true},"status":200,"error":null,"message":null,"timestamp":"2021-01-03T21:49:45.517+00:00"}
```

URL swagger:

```sh
http://localhost:8080/swagger-ui.html#/password-policies-controller
```

# Detalhes solução:

### Decisão de endpoint:
Para esse endpoint foi utilizado a estrutura /< versão api >/< resource >/< subresource >/< acao >.
Ex: /v1/passwords/policies/validate

 - < versão api >: para que seja permitindo versionar a api sem impactar os consumidores existentes dela; 
 - < resource >: nome do recurso solicitado sempre no plural;
 - < subresource >: nome do recurso filho solicitado sempre no plural, no meu desenho a intenção de validar senha é traduzida em validar a polices da senha;
 - < acao >: ação a ser efetuada, como não tem uma intenção clara apenas com metodo http,escolhi deixar um path para ação neste caso;
 - Method POST: como trata-se de validação de entidade e trafego de senha, que seria um dado sensível do sistema, foi utilizado o metodo POST para diminuir chances de captura durante o trafego na rede. Ideal utilizar https para maior segurança.

### Decisão de estrutura de entrada/saída e status http de retorno :

Entrada:

```sh
{
    "password": "string"
}
```

Saída:

```sh
{
  "data": {
    "errors": [
      {
        "message": "string",
        "rule_name": "string"
      }
    ],
    "valid": true
  },
  "error": "string",
  "message": "string",
  "status": 0,
  "timestamp": "2021-01-03T21:21:33.946Z"
}
```

Foi escolhido mater a consistêcia da estrutura de retorno, tanto para sucesso quanto para falha, a api sempre vai retornar minimamente os seguintes dados:
 - data: Foi implementado no código com generics para que seja possível reutilizar em outras apis essa estrutura, para essa api específica foi utilizado o objeto PasswordPoliciesValidatorResponseDTO;
 - error: log de erros dos status http;
 - message: mensagem retornada da api;
 - status: reflete o status do retorno do http request;
 - timestamp: timestamp da data/hora execução da chamada.
 
 Status code:
  - senha válida: retornará 200 tanto no status code de response da api quanto no campo $.status;
  - senha inválida: esse ponto gerou muitas dúvidas pois, é possível ver de dois ângulos, utilizar 200 para sinalizar que a requisição foi processada com sucesso e voltar $.data.valid como false ou voltar status code como 400, que significa erro causao pelo cliente, e voltar o body $.data.valid como false também. Após uma pesquisa achei grandes empresas utilizando das duas formas, optei por utilizar o padrão que a oracle adotou na api de senha deles, que é voltar 400. O link da api está na parte de referências.
  
### Decisão estrutura de validação de senha:
Poderia ter optado por utilizar a api de validation para realizar a validação do DTO de entrada, aplicando as regras especificadas, mas assim não seria possível mostrar o meu conhecimento sobre programação. Por conta disso escolhi utilizar alguns padrões de projetos, como Strategy para abstrair as logícas em classes com responsabilidades únicas, flexibilizar a solução e manutenção. No código é possível ver a divisão clara de cada regra solicitada pelo teste, também utilizei alguns outros padrões como Builder e singleton para os services (implementação padrão do spring com a anotação @service).

### Testes unitários e de integração:
Foi realizado uma cobertura de aproximadamente 90% do código fonte, com testes focados em garantir que todas as regras solicitadas fossem atendidas. Também foram feitos testes e2e aumentando essa garantia.

```sh
[INFO] Results:
[INFO] 
[INFO] Tests run: 46, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  7.432 s
[INFO] Finished at: 2021-01-04T08:59:42-03:00
[INFO] ------------------------------------------------------------------------
```

### Dúvidas:
 - Na minha opinião, não ficou claro se a regra "Não possuir caracteres repetidos dentro do conjunto", era case sensitive ou não, como não tenho o P.O para esclarecer, mantive case sensitive.
 - Na minha opinião, não ficou claro se a regra "Espaços em branco não devem ser considerados como caracteres válidos", servia para espaços no começo e/ou no final do texto, pois o exemplo utilizado mostrava apenas no meio do texto, optei por deixar qualquer espaço como inválido.
 - Na minha opinião, não ficou claro se caracteres diferentes dos descritos nas regras deveriam ser considerados inválidos, optei por não aplicar regras neles.
 
# Apis utilizadas como referências:

 - https://docs.camunda.org/manual/7.14/reference/rest/identity/validate-password/
 - https://docs.oracle.com/en/middleware/idm/access-manager/12.2.1.3/orpdm/op-passwordvalidaterequests-userid-post.html
