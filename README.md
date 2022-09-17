# Progetto_monolitico_gestioneOrdini

Questo è un progetto monolitico, ossia interamente in java da front-end a back-end.  
Progetto "abbastanza classico", con autenticazione del client, registrazione del client, controllo del login/logout, parametri di sessione. Si tratta di un e-commerce, quindi acquisto di prodotti con prodotti dentro il carrello, client autenticato su pagine dove può effettuare gli acquisti e parte admin dove si potranno gestire ordini/articoli. 
Viene implementato un layout tipico: menu in alto, footer, parte centrale parte dinamica con le varie scelte e poi per formattare usiamo sia css che bootstrap, è presente anche una validazione dei dati. 
Con JS la validazione dei dati si può fare anche in maniera asincrona, ossia posso validare il campo in cui sto scrivendo senza ricaricare la pagina. La chiamata asincrona sfrutta un oggetto chiamato chiamato xmlHttpRequest(??????) per fare chiamate asincrone senza attendere una risposta da parte del server. 
Come Database usiamo Oracle19c.


1. Creo nuovo progetto. Controllo se c'è Javascript collegato da modify associato a Tomcat
2. Importo il driver di oracle per la connessione

Si parte dalle tabelle > si fanno i model BC > DBAccess/vari DAO per ogni model > 
poi si parte la Business Logic con il funzionamento > si fanno le pagine front-end e i controller

3. creiamo folder SQL
4. creiamo create_script.sql per la creazione degli oggetti
5. creiamo drop_script.sql come file di pulizia
6. creiamo insert_script.sql come file di inserimento

7. Cominciamo a creare le tabelle, divise in parti: una client, una sequenze, una admin.
 	> note su create_script.sql:
 	--TABELLA UTENTE.CLIENT--
 	- facciamo la chiave su username e per questo non facciamo ID;
 	- la password ha un valore molto alto perché la stiamo codificando e non è in chiaro.
 	
 	> Relazioni.client
 	Uno a molti tra utente e ordine
 	Molti a molti tra articolo e ordine
 	Uno a uno tra articolo e immagine
 	
8. Man mano che creiamo ogni tabella, creiamo quello di pulizia relativo. Facciamo execute prima su drop, poi su create.

9. Creiamo gli insert di base delle tabelle	(mi raccomando ricordarsi il commit, senza ; dopo il commit perché su eclipse non funziona altrimenti)

10. Creiamo i model. Di base riportiamo come classi java le tabelle.
	> usiamo i nomi dei pacchetti come andrebbero messi
	> generiamo getter, setter e toString
	
11. Creiamo il BusinessComponent Carrello

12. Creiamo il package security dentro cui mettiamo AlgoritmoMD5 per codifica password.
	Questo non è l'algoritmo più sicuro, ma è il più performante.
	Qui usiamo il package Security della SE. permette di fare le conversioni tramite gli algoritmi.
	C'è un oggetto che si chiama MessageDigest che serve per creare l'algoritmo di conversione.
	Dopo di ché devo processare la password come array di byte e poi riconvertire in stringa.
	> salt: valore anche generato a caso, ma che può essere anche fisso. Più complicato è, meglio è.
		Verrà aggiunto alla codifica per generare la password. Va poi aggiunto alla codifica.

13. Test di Algoritmo > JUNIT > Nuovo JUnit Test Case 5 

14. Iniziamo a creare il dataLayer > com.mitota.architecture.dao

15. Creiamo UtenteDAO per le operazioni su Utente. E per questo mi servono le costanti DAO

16. Quindi creiamo l'interface DAOConstants in com.mitota.architecture.dao

17. Creiamo in com.mitota.architecture.DBAccess la classe DBAccess

18. Sicuramente una eccezione che avremo è SQLException, perché comunque maneggiamo DB. Cosa facciamo?
	Creiamo un'eccezione nostra, dentro com.mitota.architecture.dao facciamo una classe chiamata DAOException
	Estendiamo SQLException e dobbiamo serializzare la classe (perché è serializzata anche l'exc da cui arriva)

19. In DAOException creiamo delle costanti che fanno riferimento agli errori più tipici che possono capitare in Oracle-
	Questo serve perché non ripetiamo codice quando lanciamo SQLException, ma andrà in automatico af are quello che decidiamo nel costruttoredentro DAOException

20. Gestisco le caratteristiche di connessione, ma devo stare attento a dove lo metto. Quello fuori src o WebContent non viene interpretato
	Quindi creo un package properties con dentro > config.properties
	
21. Facciamo il JUnit Test del DBAccess

22. creiamo interfaccia GenericDAO in com.mitota.architecture.dao così da gestire oggetti generici per il DAO
	implementiamo Factory e DAO come DP
	
23. Andiamo su UtenteDAO e implementiamo GenericDAO e DAOContants
	GenericDAO riceve come param Utente (il modello) 	
	
24. Creo il JUnit di Utente DAo con @BeforeEach e @AfterEach

25. Implementiamo OrdineDAO e, in DAOCostants, DELETE_ORDINE

26. Facciamo il test su DAO. Facciamo test dopo ogni componente perché è così che si deve fare, perché
	se non proviamo singolarmente le cose, poi se c'è un errore o qualcosa non funziona come dovrebbe, 
	è più difficile fixare.
	
27. Creiamo ArticoloDAO creando in DAOConstants UPDATE_ARTICOLO, SELECT_ARTICOLO_BYID e DELETE_ARTICOLO

28. Creiamo il JUnit di ArticoloDAO. Qui decidiamo anche l'ordine di esecuzione di test. Per farlo bisogna
	usare un'annotation in alto: @TestMethodOrder(OrderAnnotation.class) e poi nei test si aggiunge @Order(1)
	L'ID è 6 perché abbiamo già degli articoli in tabella
	
29. Creiamo OrdineArticoloDAO e il relativo JUnit

30. Creiamo i BC tramite IdGenerator, che implementa singleton. Per questo creo una interface in businesscomponent.idgenerator
	IdGeneratorInterface

31. Creiamo OrdineIdGenerator e ArticoloIdGenerator

31. Creiamo il JUnit di OrdineIdGenerator. 

32. Creiamo OrdineBC, UtenteBC, OrdineArticoloBC e ArticoloBC in businesscomponent 

33. Creiamo la facciata per il client in com.mitota.businesscomponent.facade > ClientFacade

34. Creiamo com.mitota.businesscomponent.utilies con all'interno la classe LoginUtility per il controllo del login
	Un metodo per il login dell'utente e uno per quello dell'admin.
	
35. Creiamo ReportUtility

36. Creiamo la folder admin sotto WebContent per le pagine di admin

37. Lavoriamo sul web.xml. Creiamo la pagina utente (home) e quella admin (admin)

38. Creo home.jsp

39. Creiamo folder per il CSS, per JS e per immagini

40. Creiamo style.css in css e convalida.js in js

41. Dentro WebContent creo una pagina HTML, CDN.html. Lì metteremo tutte le cose da inlcudere

42. Aggiungiamo error page in web.xml

43. Le pagine admin le proteggiamo sia tramite login, ma anche con security constraint lato server (web.xml)

44. Dentro WebContent  facciamo una pagina per accessonegato.jsp da richiamare quando un utente non può effettuare delle operazioni/modifica etc

45. Creiamo anche il footer.html statico

46. Iniziamo con gli includes in accessonegato.jsp di CDN e footer

47. Iniziamo a lavorare nel foglio di stile per sistemare html, body e footer

48. Creiamo nav.jsp con il menu

49. Creiamo registra.jsp per la registrazione

50. Inseriamo datepicker in registra.jsp. Impostiamo id="dp" e poi creiamo uno script
	che recupera la function dalla libreria bootstrap in cdn
	
51. Creiamo una servlet per effettuare la registrazione in com.mitota.controller > Registrazione (la validazione la facciamo successivamente)

52. Facciamo pagina acquisti.jsp per tentare la registrazione (se la tentiamo ora, senza validazione,
	i dati devono essere giusti altrimenti darà integrità violata)
	
53. crediamo la validazione su convalida.js

	regexp: regular expression - pattern usati per fare un match con un valore che voglio controllare.
	Si controlla se il valore che devo inserire in data cosa è conforme al pattern. Si utilizza molto per
	validare i dati.
	
	Validazione data: va fatto un cambio sullo script datepicker nel form per catturare l'onchange
	L'unicità dello username lo verifichiamo in altra sede
	
54. Creiamo login.jsp e servlet controllo

55. Mettiamo controlli di sessione su login.jsp: se già loggato, fa redirect ad acquisti

56. Creiamo logout.jsp

57. Modifichiamo acquisti.jsp così da mostrare gli articoli presenti

58. Creiamo il controller per aggiungere i dati in carrello (AggiungiCarrello)

59. Creiamo carrello.jsp con metodo rimuoviArticolo, con relativa Servlet

60. Aggiungiamo pagina di errore.jsp ed error404

61. Aggiungiamo Servlet per completare ordine e home page.

62. Iniziamo a lavorare sul lato admin creando l'AdminFacade

63. Sistemo la navbar lato admin
