package market.dto;

import java.time.LocalDateTime;

public class ProductDTO {

    private long productId;
    private String title;
    private int price;
    private String status;
    private LocalDateTime createAt;

    public ProductDTO() {
    }

    public ProductDTO(long productId, String title, int price, String status, LocalDateTime createAt) {
        this.productId = productId;
        this.title = title;
        this.price = price;
        this.status = status;
        this.createAt = createAt;
    }

    public ProductDTO(String title, int price, String status) {
        this.title = title;
        this.price = price;
        this.status = status;
    }

    public long getProductId() {
        return productId;
    }
    public void setProductId(long productId) {
        this.productId = productId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDateTime getCreateAt() {
        return createAt;
    }
    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "productId=" + productId + ", title=" + title + ", price=" + price + ", status=" + status + ", createAt=" + createAt + '}';
    }
}
