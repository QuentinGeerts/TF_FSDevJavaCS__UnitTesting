# Exercices

## Exercice 01 - Note

Implémentez la méthode getLetterNote dans la classe Note,
qui prend un entier représentant un résultat d'année (compris entre 0 et 100)
et renvoie une lettre correspondant à ce résultat selon la grille suivante :
- 'F' pour les notes inférieures à 50,
- 'E' pour les notes entre 50 et 59,
- 'D' entre 60 et 69,
- 'C' entre 70 et 79,
- 'B' entre 80 et 89,
- 'A' entre 90 et 100.

Si la note est en dehors de la plage [0, 100], une exception IllegalArgumentException
  doit être levée avec le message "Year result must be between 0 and 100".