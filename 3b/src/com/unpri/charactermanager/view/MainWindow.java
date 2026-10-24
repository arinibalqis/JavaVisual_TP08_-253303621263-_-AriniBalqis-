package com.unpri.charactermanager.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

public class MainWindow extends JFrame {

    private CharacterManager characterManager;

    public MainWindow(CharacterManager characterManager) {

        this.characterManager = characterManager;

        // Pengaturan jendela
        setTitle("Character Manager v0.3");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel utama
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));

        // Judul
        JLabel titleLabel = new JLabel(
                "CHARACTER MANAGER",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Panel daftar karakter
        JPanel characterPanel = new JPanel();

        characterPanel.setLayout(
                new BoxLayout(
                        characterPanel,
                        BoxLayout.Y_AXIS
                )
        );

        // Mengambil semua karakter
        List<Character> characters =
                characterManager.getAllCharacters();

        // Menampilkan karakter secara dinamis
        for (Character character : characters) {

            JLabel characterLabel = new JLabel(
                    "Nama: " + character.getName()
                    + " | Level: " + character.getLevel()
                    + " | Tipe: " + character.getType()
            );

            characterLabel.setFont(
                    new Font("Arial", Font.PLAIN, 15)
            );

            characterLabel.setBorder(
                    BorderFactory.createEmptyBorder(
                            5, 10, 5, 10
                    )
            );

            characterPanel.add(characterLabel);
        }

        // Scroll
        JScrollPane scrollPane =
                new JScrollPane(characterPanel);

        mainPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        // ==========================
        // RATA-RATA LEVEL
        // ==========================

        double totalLevel = 0;

        for (Character character : characters) {
            totalLevel += character.getLevel();
        }

        double averageLevel = 0;

        if (!characters.isEmpty()) {
            averageLevel =
                    totalLevel / characters.size();
        }

        JLabel averageLabel = new JLabel(
                "Rata-rata Level: "
                + String.format("%.2f", averageLevel),
                SwingConstants.CENTER
        );

        averageLabel.setFont(
                new Font("Arial", Font.BOLD, 16)
        );

        averageLabel.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 10, 10, 10
                )
        );

        mainPanel.add(
                averageLabel,
                BorderLayout.SOUTH
        );

        // Masukkan panel ke JFrame
        add(mainPanel);
    }
}