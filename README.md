# Sistema controle de Inventario

Com esse sistema voce sera capaz de criar produtos e controlar o estoque dele importando e exportando arquivo para controle de estoque e inventario

## Funçoes
### **Produto**
**Listar todos os produtos:** para obter uma lista de todos os produtos voce deve fazer a seguinte chamada ```GET HTTP://localhost:8080/product``` com isso voce recebera como retorno um status code 200 e uma lista de produtos no formato *JSON*
```json
[
 {
  "id": 3,
  "description": "Feijao Carioca",
  "inventory": 158,
  "price": 7.90
 }
]
```

**Cadastrar Produto:** Para cadastrar produto voce deve fazer a seguinte chamada ```POST HTTP://localhost:8080/product``` e informar o seguinte body
```json
{
  "description": "Feijao Carioca",
  "price": 7.90
}
```
perceba que para cadastrar o produto não informamos o *"inventory"* pois essa informação é calculada com base nas **MOVIMENTAÇÕES** que são um outro conjunto de comandos.
Se ocorrer tudo bem voce deve apenas o texto ```Produto cadastrado com sucesso``` e o status code 201

**Alterar produto:** Para alterar o cadastro de um produto voce deve acionar o endpoint ```PATH HTTP://LOCALHOST:8080/PRODUCT``` passando quase o mesmo *body* de cadastrar um produto
porem agora com a propriedade *id* ficando da seguinte forma
```Json
 {
  "id": 3,
  "description": "Feijao Carioca Alterado",
  "price": 8.95
 }
```
em caso de sucesso ira receber o status code ```201``` significando que ocorreu tudo bem com a operação.

**Deletar produto:** para deletar o cadastro de produto é muito simples basta fazer a chamada da requisição no endpoint
```DELETE HTTP:LOCALHOST:8080/PRODUCT/{id}``` onde o campo ***id*** deve ser trocado pelo codigo do produto que deseja realizar a exclusão,
vale lembrar que ao fazer a exclusão do produto tambem sera deletado todas as movimentações vinculadas a esses produtos.