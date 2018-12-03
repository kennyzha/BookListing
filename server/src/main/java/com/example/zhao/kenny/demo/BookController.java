package com.example.zhao.kenny.demo;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class BookController {

    @Autowired
    public BookService bookService;

    @CrossOrigin
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Book> searchBooks(@RequestParam(value="q") String query){
        List<Book> books = bookService.getBooks(query);
        return books;
    }
}
