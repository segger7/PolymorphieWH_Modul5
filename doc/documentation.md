# Lerntagebuch Modul 5

### Modul 5 Teil 1 (02.10.2024)

#### Alle Charakter Klassen hinzugefügt

#### Die Klasse Character

Zuerst wurde eine neue abstrakte Klasse Character erstellt, die
die Vorlage für alle zukünftig hinzuzufügenden Charaktere bereitstellt.
Alle Charaktere verfügen über die Datenfelder name, healthpoints, specialAbilityActive, attackDamageMin und attackDamageMax.

Der Konstruktor verfügt über nur einen Parameter, das ist der Name, der Rest wird intern festgelegt. Ein Standard-Charakter hat zu Beginn 100 Lebenspunkte und die Spezialfähigkeit ist deaktiviert.

Die Methoden activate- und deactivateSpecialAbility()
schalten jeweils die Spezialfähigkeit aus und ein, und sind dafür gedacht sie ihn Unterklassen zu überschreiben um angepasste Spezialfähigkeitsverhalten zu implementieren.

Zusätzlich gibt es noch die Methoden takeDamage() und attack()

takeDamage: Diese Methode hat einen Parameter vom Typ int der angibt wie viele
Lebenspunkte abgezogen werden sollten.

attack: Diese Methode hat einen Parameter vom Typ Character. Dieser stellt den Gegner dar und fügt im, in dem man die takeDamage() Methode von ihm aufruft, einen Schaden in einer zufälligen Höhe zwischen Minimum-Schaden und Maximal-Schaden dar.

#### Die Klasse Dragon:

Der Drache erbt von Character und überschreibt folgende Funktionalitäten:
Der Min-, und Maxschaden wurde angepasst,und  die Spezialfähigkeit.
Bei der Spezialfähigkeit erhält ein Drache um 10 mehr Leben und bekommt 5-10 weniger Schaden.

#### Die Klasse Dwarf (Zwerg):

Der Zwerg erbt von Character und überschreibt folgende Funktionalitäten:
Der Min-, und Maxschaden wurde angepasst,und  die Spezialfähigkeit.
Bei der Spezialfähigkeit, die sich nur aktivieren lässt wenn der Zwerg weniger wie 50 Leben hat, hat er eine 50%ige Chance seinen Schaden beim Angriff zu verdoppeln, anderenfalls jedoch macht er nur halb so wie Schaden.

### Modul 5 Teil 2 (02.10.2024)