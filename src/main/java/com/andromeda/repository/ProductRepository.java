package com.andromeda.repository;

import com.andromeda.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Product findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM products WHERE id = ?", new Object[]{id}, this::mapRowToProduct);
    }

    public List<Product> findAll() {
        return jdbcTemplate.query("SELECT * FROM products", this::mapRowToProduct);
    }

    public int save(Product product) {
        return jdbcTemplate.update("INSERT INTO products (creator_id, name, description, price, created, updated) VALUES (?, ?, ?, ?, ?, ?)",
                product.getCreator().getId(), product.getName(), product.getDescription(), product.getPrice(), product.getCreated(), product.getUpdated());
    }

    public int update(Product product) {
        return jdbcTemplate.update("UPDATE products SET name = ?, description = ?, price = ?, updated = ? WHERE id = ?",
                product.getName(), product.getDescription(), product.getPrice(), product.getUpdated(), product.getId());
    }

    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM products WHERE id = ?", id);
    }

    private Product mapRowToProduct(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getLong("id"));
        product.setName(rs.getString("name"));
        product.setDescription(rs.getString("description"));
        product.setPrice(rs.getDouble("price"));
        product.setCreated(rs.getDate("created"));
        product.setUpdated(rs.getDate("updated"));
        // Assuming User entity has a method findById in UserRepository
        // product.setCreator(userRepository.findById(rs.getLong("creator_id")));
        return product;
    }
}
