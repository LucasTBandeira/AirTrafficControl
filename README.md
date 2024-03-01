# AirTrafficControl

Projeto Back-end de um sistema de controle de tráfego aéreo desenvolvido em Java(Spring Boot). Envolveu a criação de API REST considerando princípios SOLID e arquitetura limpa. Utilização do JPA como interface para frameworks de persistência de dados.

Para rodar o programa são necessários Maven e Java instalados. O passo a passo para rodar o programa está abaixo:
1 - Compile e construa o projeto com o comando mvn clean install. Isso criará um arquivo JAR no diretório target do seu projeto.
2 - Navegue até o diretório target com o comando cd target.
3 - Execute o jar com o comando: java -jar airtrafficControl-0.0.1-SNAPSHOT.jar (se necessário substitua o nome do jar)

Agora, usando o Postman, por exemplo, é possível fazer as seguintes requisições: 

Listar todas Aeronaves:
Fazer uma requisição GET na url localhost:8080/scta/allAeronaves

Listar todos Planos de Voos:
Fazer uma requisição GET na url localhost:8080/scta/allPlanos

Listar todas Rotas:
Fazer uma requisição GET na url localhost:8080/scta/allRotas

Listar todas rotas entre dois locais:
Fazer uma requisição GET na url localhost:8080/scta/rotas/{origem}/{destino}
Ex: localhost:8080/scta/rotas/Brasilia/Fortaleza

Listar todos os Slots que estão disponíveis para as aeronaves utilizarem em determinada rota e em determinado dia e horário:

Fazer uma requisição POST na url localhost:8080/scta/slotslivres e utilizar um json no seguinte formato:
{"rota":"POAFLO10","data":"11/10/2024","horario":"10:42","velocidadeCruzeiro":850 } 

Avaliar se determinado plano de voo é valido:
Fazer uma requisição POST na url localhost:8080/scta/avaliaPlanoDeVoo e utilizar um json no seguinte formato:
{"aeronave": "PTABA", "rota":"sp-rj","altitude":262000,"slots":[-1,11,12,13],"data":"20/03/2023"}

Aprovar um plano de voo:
Fazer uma requisição POST na url localhost:8080/scta/avaliaPlanoDeVoo e utilizar um json no seguinte formato:
{"aeronave": "PTABA", "rota":"sp-rj","altitude":26200,"slots":[11,12,13],"data":"20/03/2023"}

Cancelar Plano De Voo:
Fazer uma requisição GET na url localhost:8080/scta/cancela/{id_do_plano} 
Ex: localhost:8080/scta/cancela/1
