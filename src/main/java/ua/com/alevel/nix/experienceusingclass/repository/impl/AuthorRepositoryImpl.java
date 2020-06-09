package ua.com.alevel.nix.experienceusingclass.repository.impl;

import ua.com.alevel.nix.experienceusingclass.data.Author;
import ua.com.alevel.nix.experienceusingclass.repository.AuthorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorRepositoryImpl implements AuthorRepository {

    private final List<Author> authorList = new ArrayList<>();

    public Author findByFullName(final String fullName) {
        for(Author author : authorList){
            if (author.getFullName().equals(fullName)){
                return author;
            }
        }
        return null;
    }

    public void save(Author author) {
        authorList.add(author);
    }

    public Author findById(Long id) {
        for (Author author : authorList){
            if (author.getId().equals(id)){
                return author;
            }
        }
        return null;
    }

    public List<Author> findAll() {
        return authorList;
    }

    public void update(Author author) {
        for (Author currAuthor : authorList){
            if (author.getId().equals(currAuthor.getId())) {
                currAuthor.setFullName(author.getFullName());
            }
        }
    }

    public void remove(Long id) {
        for (int i = 0; i < authorList.size(); i++) {
            if (authorList.get(i).getId().equals(id)) {
                authorList.remove(i);
            }
        }
    }
}
