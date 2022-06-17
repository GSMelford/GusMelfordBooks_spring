package com.gusmelford.gusmelfordbooks_spring.services.shop;

import com.gusmelford.gusmelfordbooks_spring.entities.Book;
import com.gusmelford.gusmelfordbooks_spring.entities.Order;
import com.gusmelford.gusmelfordbooks_spring.entities.User;
import com.gusmelford.gusmelfordbooks_spring.payload.domain.UserBook;
import com.gusmelford.gusmelfordbooks_spring.repositories.BookRepository;
import com.gusmelford.gusmelfordbooks_spring.repositories.OrderRepository;
import com.gusmelford.gusmelfordbooks_spring.repositories.UserRepository;
import com.gusmelford.gusmelfordbooks_spring.services.interfaces.shop.ShopService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public List<UserBook> getUserBooks(String email) {
        List<UserBook> userBooks = new ArrayList<>();
        List<Order> orders = orderRepository
                .findAll()
                .stream()
                .filter(x -> Objects.equals(x.getCustomer().getEmail(), email))
                .toList();

        for(Order order : orders) {
            for(Book book : order.getBooks()) {
                userBooks.add(new UserBook(
                        book.getTitle(),
                        book.getPrice(),
                        order.createdOn
                ));
            }
        }

        return userBooks;
    }

    public UUID createOrder(String email, List<UUID> bookIds) {
        User customer = userRepository.findByEmail(email).orElseThrow();

        Order order = new Order();
        List<Book> books = new ArrayList<>();
        for(UUID bookId : bookIds) {
            books.add(bookRepository.findById(bookId).orElseThrow());
        }

        order.setCustomer(customer);
        order.setBooks(books);
        order.setPrice(books.stream().mapToDouble(Book::getPrice).sum());

        orderRepository.save(order);
        return order.getId();
    }
}

