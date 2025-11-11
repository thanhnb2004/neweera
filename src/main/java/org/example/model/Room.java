package org.example.model;

public class Room  {

    // 1. Thuộc tính (Fields)
    private int id; // integer(10) - Khóa chính
    private String name; // varchar(255)
    private String type; // varchar(255)
    private int capacity; // varchar(255) - (Lưu ý: Nếu capacity là số nguyên, ta dùng 'int')

    // 2. Hàm tạo mặc định (No-argument Constructor)
    public Room() {
    }

    // 3. Hàm tạo có đối số (All-argument Constructor)
    public Room(int id, String name, String type, int capacity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    // 4. Các phương thức Getter và Setter

    // Getter và Setter cho id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter và Setter cho name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter và Setter cho type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getter và Setter cho capacity
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // (Tùy chọn) 5. Phương thức toString() để dễ dàng in thông tin đối tượng
    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
