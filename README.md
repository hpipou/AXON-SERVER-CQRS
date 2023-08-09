# AXON SERVER, CQRS

PROJET SPRING BOOT (COMMANDS/QUERIES), AVEC AXON SERVER.

```bash
SPRING BOOT VERSION => 3.1.2
AXON FRAMEWORK VERSION => 4.8.0
SPRINGDOC VERSION => 2.2.0
JAVA VERSION => 17
```
#### ⚡️ Remarque : Axon Server a été lancé sur DOCKER (Port:8124)

```bash
docker run -d --name axon-server -p 8024:8024 -p 8124:8124 --network springbankNet --restart always axoniq/axonserver:latest
```
#### ⚡️ Pour accéder à l'interface graphique de AXON :
```bash
localhost:8024
```

![App Screenshot](https://raw.githubusercontent.com/hpipou/AXON-SERVER-CQRS/main/images/AXON%20SERVER.png)

@LAMINE

#### ⚡️ Auteur :

- [@hpipou](https://www.github.com/hpipou)
