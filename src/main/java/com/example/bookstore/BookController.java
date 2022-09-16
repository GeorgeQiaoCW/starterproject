package com.example.bookstore;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookStore store;

    public BookController(BookStore store) {
        this.store = store;
    }

    @Operation(summary = "Add a book to the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book added",
                    content = {@Content(mediaType = "integer") }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content)
    })
    @PostMapping("/add")
    public ResponseEntity putBook(@RequestParam String name, @RequestParam String description){
        if(name.equals(null) || name.isBlank() || description.equals(null) || description.isBlank()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Book book = new Book();
        book.setName(name);
        book.setDescription(description);
        long id = store.save(book).getId();
        return new ResponseEntity(id, HttpStatus.OK);
    }

    @Operation(summary = "Get a books in database with given ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content)
    })
    @GetMapping("/book")
    public ResponseEntity getBookById(@RequestParam int id){
        Book temp = store.findBookById(id);
        if(!temp.equals(null)){
            return new ResponseEntity<>(temp, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Get all books in database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all book",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Book.class)) }),
    })
    @GetMapping(path="/all")
    public List<Book> getAllBooks() {
        return store.findAll();
    }
}
