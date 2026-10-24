package com.unpri.charactermanager;

import javax.swing.SwingUtilities;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

public class Main {

    public static void main(String[] args) {

        // Membuat CharacterManager
        CharacterManager manager = new CharacterManager();

        // Karakter pertama
        Character arthur = new Character(
                1,
                "Arthur",
                20,
                CharacterType.WARRIOR
        );

        // Karakter kedua
        Character merlin = new Character(
                2,
                "Merlin",
                15,
                CharacterType.MAGE
        );

        // Karakter ketiga
        Character robin = new Character(
                3,
                "Robin",
                18,
                CharacterType.ARCHER
        );

        // Karakter baru pertama
        Character lancelot = new Character(
                4,
                "Lancelot",
                22,
                CharacterType.WARRIOR
        );

        // Karakter baru kedua
        Character morgana = new Character(
                5,
                "Morgana",
                25,
                CharacterType.MAGE
        );

        // Menambahkan karakter ke CharacterManager
        manager.addCharacter(arthur);
        manager.addCharacter(merlin);
        manager.addCharacter(robin);
        manager.addCharacter(lancelot);
        manager.addCharacter(morgana);

        // Menjalankan GUI melalui Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {

            MainWindow window = new MainWindow(manager);

            window.setVisible(true);
        });
    }
}