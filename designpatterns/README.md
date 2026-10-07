# Desafio de Design Patterns com Spring Boot

Projeto desenvolvido para o desafio de Design Patterns da DIO / Bootcamp Itaú Java com IA.

## 📌 Padrões de Projeto Utilizados

- **Facade**: Centralizado no `PedidoFacadeService`, unificando a integração externa com a API do ViaCEP, a persistência de endereços e pedidos no banco de dados, e o processamento de pagamento.
- **Strategy**: Implementado na interface `PagamentoStrategy`, permitindo alternar dinamicamente a lógica de pagamento (`PagamentoPix`, `PagamentoCartao`) através do `PagamentoContext`.
- **Singleton**: Garantido pelo container do Spring Boot, que gere os componentes (`@Service`, `@Component`, `@RestController`) como instâncias únicas na aplicação.

---

## 🚀 Como Executar e Testar

### 1. Iniciar a Aplicação
Executa a classe `DesignpatternsApplication.java`. A aplicação vai subir na porta `8080`.

### 2. Exemplo de Requisição (Criar Pedido)
Abre o terminal e executa a chamada `POST`:

```powershell
curl.exe -X POST "http://localhost:8080/pedidos?cliente=Yasmin&valor=100.0&cep=01001000&formaPagamento=PIX"

### 3. Exemplo de Retorno (JSON)
```json
{
  "id": 1,
  "cliente": "Yasmin",
  "valor": 100.0,
  "formaPagamento": "PIX",
  "statusPagamento": "PAGO VIA PIX COM 10% DE DESCONTO: R$ 90.0",
  "enderecoEntrega": {
    "cep": "01001-000",
    "logradouro": "Praça da Sé",
    "bairro": "Sé",
    "localidade": "São Paulo",
    "uf": "SP"
  }
}