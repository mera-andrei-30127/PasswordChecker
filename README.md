# PasswordChecker
        Proiectul contine 2 interfate, o clasa main care face posibila citirea parolei, 5 clase de verificare a parolei si o clasa de validare pentru parola.

         El este structurat folosind un design pattern de tipul Factory si este optimizat pentru a implementa diferite solid principles, ca de exemplu Single Responsibility Principle, Interface Segregation Principle si Open for Extension Closed for Modification.
  
         Clasa principala Main citeste o parola atata timp cat nu este intalnit stringul "end" si afiseaza erorile in cazul in care parola nu indeplineste conditiile necesare, numarul minim de modificari care trebuiesc facute pentru ca parola sa fie una corecta, iar in cazul in care parola introdusa este corecta se afiseaza mesajul "correct password".
         
         Interfata IError contine o metoda care faciliteaza afisarea erorilor pentru diferite teste pe parola, iar interfata IVerifyCharacters contine testele care se fac asupra parolei pentru a determina daca este corecta sau nu.
  
          Clasele care implementeaza aceste interfete sunt: DigitVerify, PasswordLength, UpperCaseLetter, LowerCaseLetter, VerifyGroupOfCharacters.  Clasa DigitVerify verifica daca in parola exista cel putin o cifra, clasa PasswordLength verifica daca parola este cuprinsa intre 6-20 caractere, clasa UpperCaseLetter verifica daca exista o litera mare, clasa LowerCaseLetter verifica daca exista o litera mica, iar clasa VerifyGroupOfCharacters verifica grupuri de cate 3 caractere, in cazul in care grupul contine caractere de acelasi fel se returneaza numarul de astfel de grupuri gasite.
  
         Clasa Validation primeste parola ca si paramentru, instantiaza clasele de verificare pentru parola, le pune intr-o structura de tipul hash map si apoi verifica daca clasele de verificare au returnat eroare. In acest timp se contorizeaza numarul erorilor, iar daca exista erori de grupuri de 3 caractere asemanatoare si erori de cifra lipsa de exemplu (daca se inlocuieste un caracter din grup cu o cifra parola va fii corecta) va afisa faptul ca exista o singura eroare in parola. La final afiseaza numarul erorilor si faptul ca parola este gresita sau nu.
