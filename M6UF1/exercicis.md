## Exercicis

### Operacions sobre fitxers

#### Exercici 1. Versió simple de *ls*.

Fes un programa que rebi un nom de directori com a paràmetre i mostri el seu
contingut, indicant en cada cas si es tracta d'un fitxer o directori i els
permisos que tenim sobre ell.

La sortida tindrà un aspecte similar a aquest:

```
-rw- fitxer
drwx directori
...
```

#### Exercici 2. Versió simple de *ls -R*

Fes un programa que rebi un nom de directori com a paràmetre i mostri el seu
contingut, indicant en cada cas si es tracta d'un fitxer o directori i els
permisos que tenim sobre ell.

El programa actuarà recursivament, mostrant el contingut de tots els
subdirectoris amb què es vagi trobant.

Per fer-ho, utilitza una pila on es guardin els noms de directoris pendents de
mostrar.

#### Exercici 3. Versió simple del *cp*

Fes un programa que rebi per paràmetres el nom d'un fitxer i el nom d'un
directori i que copiï el fitxer dins del directori.

**Pista**: utilitza el mètode *Files.copy*.

### Fitxers binaris

#### Exercici 1. Genera secret

En aquest programa, es generarà un fitxer binari que contindrà una sèrie de
parelles codi-secret. El codi és un nombre enter i el secret una cadena de 3
caràcters. El fitxer estarà ordenat de menor a major pels codis.

Per generar el fitxer es procedirà de la següent manera: el primer codi serà un
nombre aleatori entre 1 i 3. Cadascun dels següents codis serà com l'anterior
sumant-hi una quantitat entre 1 i 3. Els secrets seran combinacions de tres
lletres agafades aleatòriament d'entre el conjunt de lletres minúscules.

El programa generarà un total de 1000 parelles codi-secret.

*Nota*: per guardar les cadenes utilitza *writeChars* i no *writeUTF*, ja que
la longitud d'una cadena UTF és variable.

#### Exercici 2. Detector de text.

Fes un programa que rebi per paràmetre un o més noms de fitxer i que, per a
cadascun d'ells, mostri per pantalla només aquelles parts que són text,
saltant-se les parts binàries.

Utilitza mètodes de *Character* per a la detecció senzilla de què és text i
què no.

Un error en un fitxer no ha d'interrompre el programa, que haurà de saltar
al fitxer següent.

### Fitxers d'objectes

#### Exercici 1. El jardí persistent

En aquest exercici farem una nova versió del programa del
[jardí](M3UF4/1-classes/exercicis/jardi.md) ([codi](M3UF4/1-classes/codi/jardi)).

A la versió actual, el temps passava cada cop que l'usuari introduïa una línia
de text, excepte si escrivia *surt*, moment en què s'acabava el programa.

En aquesta versió, quan l'usuari escrigui *surt* es guardarà l'estat del
jardí utilitzant un *ObjectStream*. Sempre es guardarà al mateix fitxer, de
nom *jardi.sav*.

Quan es torni a executar el programa, el primer que ha de fer és comprovar si
hi ha una partida a mitges guardada, carregar-la si és el cas, i prosseguir
des del lloc on estava.

### Fitxers d'accés aleatori

#### Exercici 1. Modificar països

A partir de l'exemple d'escriptura d'un fitxer d'accés aleatori crea un programa
que permeti modificar un valor (*nom*, *codi*, *població* o *capital*) d'un
dels registres emmagatzemats al fitxer *paisos.dat*.

El programa demanarà l'índex del registre que es vol modificar, nom de la dada
que es vol modificar, el nou valor que es vol introduir.

#### Exercici 2. Sobreescriptura de països

Crea un programa que permeti intercanviar un país del fitxer *paisos.dat* per
un país nou.

El programa demanarà l'índex que ha d'ocupar el nou país i cadascun dels
valors d'aquest i tot seguit sobreescriurà amb les noves dades el registre
ubicat a la posició indicada.

#### Exercici 3. Cerca el secret

Aquest programa utilitza el fitxer generat a l'exercici *genera secret*.

Es demanarà un codi a l'usuari i es cercarà al fitxer. Per fer-ho,
s'utilitzarà una cerca binària: es començarà pel codi que hi ha a la mitat
del fitxer, es mirarà si és major o menor que el codi demanat, i es procedirà
amb la mitat corresponent del fitxer. Utilitza un fitxer d'accés aleatori per
poder-ho fer.

El programa mostrarà el secret que correspon al codi introduït, si hi és, o
indicarà que no hi és en cas contrari.

### Fitxers de text

#### Exercici 1. Comptar *a*

Fes un programa que demani un nom de fitxer a l'usuari, i mostri quantes
lletres '*a*' hi ha al fitxer.

#### Exercici 2. Versió simple del grep

Fes un programa que rebi per paràmetre una cadena de text i un fitxer i que
mostri per pantalla només aquelles línies del fitxer que contenen la cadena.

#### Exercici 3. Versió no tan simple del grep

Aquest programa acceptarà les següents sintaxis:

```
java <nom_programa> <text> <directori>
java <nom_programa> <text> <fitxer>...
```

En el primer cas, es mostraran per pantalla les línies de cada fitxer
incloses a *&lt;directori&gt;* que continguin *&lt;text&gt;*, indicant en cada cas
el nom del fitxer i el número de línia.

En el segon cas, es mostraran per pantalla les línies de cadascun dels
fitxers indicats que continguin *&lt;text&gt;*, indicant en cada cas el nom
del fitxer i el número de línia.

#### Exercici 4. Versió simple del tee

Fes un programa que guardi tots els caràcters que rebi per l'entrada estàndard
a un fitxer el nom del qual es rep per paràmetre i que a més els mostri per
pantalla. El programa ha d'actuar caràcter a caràcter.

#### Exercici 5. MiniShell.

En aquest programa implementarem una versió molt reduïda d'una línia de
comandes.

El programa guardarà el directori de treball en una variable, que
s'inicialitzarà al directori del projecte.

**Nota**: per saber aquest directori es pot utilitzar
`System.getProperty("user.dir")`.

El prompt del nostre shell indicarà el directori actual seguit del símbol ">".

El programa acceptarà les comandes *cd*, *ls* i *cat*:

* *cd* permetrà canviar el directori de treball. Ha d'acceptar tant rutes
absolutes com relatives.

* *ls* mostrarà el contingut del directori actual. Es mostrarà un símbol "/"
després dels directoris.

* *cat* rebrà el nom d'un fitxer del directori actual i en mostrarà el
contingut.

### Fitxers XML

#### Exercici 1.

A partir de la classe *Persona*, que tindrà informació sobre el nom i l'edat
de les persones, realitza les tasques següents:

a) Crea un fitxer de nom *persones.bin* que emmagatzemi diversos objectes
*Persona* en format binari (ha de guardar el nom i l'edat de cada persona,
no l'objecte sencer).

b) Fes un programa que llegeixi el fitxer anterior i creï un document XML
adequat utilitzant DOM.

c) Implementa un mètode que permeti llegir el document XML de l'apartat
anterior i reconstruir una llista d'objectes *Persona*.

d) Crea una plantilla XSL per crear una presentació en HTML del fitxer XML
generat.

e) Utilitza SAX per a visualitzar el contingut del fitxer que hem creat a
l'exercici anterior.

#### Exercici 2. Recompte d'elements

Aquest programa rebrà un nom de fitxer XML per paràmetre, a partir del qual,
utilitzant SAX, recomptarà i mostrarà per pantalla quantes etiquetes de cada
tipus apareixen al fitxer.
