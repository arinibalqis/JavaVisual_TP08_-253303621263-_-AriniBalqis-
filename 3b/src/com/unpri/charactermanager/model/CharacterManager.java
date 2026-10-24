package com.unpri.charactermanager.model;

import java.util.ArrayList;
import java.util.List;

public class CharacterManager {

    private ArrayList<Character> characters;

    public CharacterManager() {
        characters = new ArrayList<>();
    }

    // Menambahkan karakter
    public boolean addCharacter(Character character) {

        if (character == null) {
            return false;
        }

        // Mencegah nama karakter duplikat
        if (findByName(character.getName()) != null) {

            System.out.println(
                    "Nama karakter sudah digunakan"
            );

            return false;
        }

        characters.add(character);

        return true;
    }

    // Mencari karakter berdasarkan nama
    public Character findByName(String name) {

        for (Character character : characters) {

            if (character.getName()
                    .equalsIgnoreCase(name)) {

                return character;
            }
        }

        return null;
    }

    // Menghapus karakter
    public boolean removeCharacter(String name) {

        Character character =
                findByName(name);

        if (character != null) {

            characters.remove(character);

            return true;
        }

        return false;
    }

    // Jumlah karakter
    public int getTotalCharacters() {

        return characters.size();
    }

    // Mengambil semua karakter
    public List<Character> getAllCharacters() {

        return new ArrayList<>(characters);
    }

    // Mencari berdasarkan tipe
    public List<Character> findByType(
            CharacterType type) {

        List<Character> result =
                new ArrayList<>();

        for (Character character : characters) {

            if (character.getType() == type) {

                result.add(character);
            }
        }

        return result;
    }
}