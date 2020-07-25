Prove that it is working correctly:
    - consider ca testele din AppTest acopera cazurile pentru o functionare normala a aplicatiei.

Make it so that a novice programmer cannot use it the wrong way:
    - pentru cazul acesta, am facut clasa ce se ocupa de functionalitatea ceruta (StringFed) singleton, 
      pentru ca am plecat de la premisa in care stocarea are formatul unei baze de date, astfel ar trebui sa existe
      doar un singur obiect ce sa instantieze aceasta clasa.
      Functiile ce se ocupa cu fed-url si ce ce se ocupa cu returnarea datelor, acopera cazuri in care inputul este null.

Nor that an evil programmer can break it:
    - pentru acest caz am protejat toate atributele interne facandu-le private si clasa (StringFed) am definit-o ca fiind final ca sa nu mai poata fi mostenita.

PS1: o serie de comentarii explicative se afla in cod

PS2: in dezvoltarea aplicatiei am incercat sa nu fac optimizari premature.

PS3: pentru cazul 'Nor that an evil programmer can break it', in caz ca aceasta clasa va fi utilizata ca un api,
    idk, ca un microservice pentru a limita numarul de requesturi de la un IP extern eu as utiliza o solutie ca API Umbrela (pentru Rate Limiting), spre exemplu, un IP extern poate face request sa introduca un string odata / secunda si sa obtina informatii despre stringuri odata la 5 minute.
    Asta depinde si de utilizarea aplicatiei.

PS4: va multumesc pentru aceasta provocare, chiar mi-a prins bine, Multumesc ^^.

PS5: pentru dev, am folosit ca IDE VisualCode, iar JDK-ul (JDK11) l-am folosit prin WSL2 (Ubuntu20.04), #nuMiPreaPlaceEclipse. Proiectul l-am generat cu utilizat mvn si de testat se poate testa cu 'mvn test'.
