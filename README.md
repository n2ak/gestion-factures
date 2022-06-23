Dans l'application le client ne connaise que le service Gatway,tout les requêtes envoyer par le client suivi par le nom de service sont envoyer vers le Gateway(proxy),
et le moment quand le gateway connait le service il va contacter le micro-service d'enregistrement pour lui fournir tous les informations de micro-service pour ce communiquer directement avec le service demander par le client.
Pour éviter de créer un fichier de configuartion de chaque micro-service, on utilise un service de configuration.
On utilise Rest pour la communication entre les services c'est une communication synchrone.
## Micro-services (Customer,inventory et billing)
dans ces services, j'ai effectué un travail régulier de création de microservices simples (création d'objets dto, d'objets openfeign, de mappeurs de structures()strct mappers,JPA repositories, les entités et de contrôleurs)
#### Customer
DB name : customer-db<br>
Port: 8081
#### Inventory
DB name : inventory-db<br>
Port: 8083
#### Billing
DB name : billing-db<br>
Port: 8082

![image](screenshots/bill.PNG)
![image](screenshots/bill1.PNG)

## Eureka service :
Port: 8761

Dans ce service, j'ai configuré un service de discovery avec lequel tous les services vont s'enregistrer

![image](screenshots/eureka.PNG)
## Gateway service:
Port: 8888

le service gateway joue le rôle d'interface pour tous les services, de sorte que le client n'a à connaître qu'une seule adresse et à lui faire des requêtes

![image](screenshots/gateway1.PNG)
![image](screenshots/gateway2.PNG)
![image](screenshots/gateway3.PNG)
![image](screenshots/gateway4.PNG)
![image](screenshots/gateway5.PNG)

## Front-end
j'ai utilisé le framework React pour créer un front-end pour ce projet

![image](screenshots/front1.PNG)
![image](screenshots/front2.PNG)
![image](screenshots/front3.PNG)
![image](screenshots/front4.PNG)
![image](screenshots/front5.PNG)
![image](screenshots/front6.PNG)

## Facturations Producer
dans cette partie j'ai essayé d'implémenter un service qui simule un producteur de kafka qui envoie des factures à un topic kafka

![image](screenshots/fact_prod1.PNG)

## Facturations Consumer
dans cette partie, j'ai essayé d'implémenter un service qui reçoit des messages d'un topic kafka (envoyé par le simulateur de producteur) et les écrit dans un fichier csv

![image](screenshots/fact_cons1.PNG)

## Real-time Analytics
Dans cette section, j'ai essayé de faire des analyses en temps réel à l'aide de kafka streams, et la tâche consistait à calculer le nombre de facturations et le montant total à payer pour chaque client pour les 5 dernieres secondes

![image](screenshots/aaaa.PNG)

## Batch-processing
dans cette section, j'ai essayé d'effectuer un batch preocessing à l'aide du spring batch et la tâche consistait à calculer une remise de 30% sur toutes les factures

![image](screenshots/batch.PNG)

