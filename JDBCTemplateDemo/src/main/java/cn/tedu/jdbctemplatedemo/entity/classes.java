package cn.tedu.jdbctemplatedemo.entity;

public class classes {
    private long id;
    private String name;
    private long floor;
    private long teacherId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getFloor() {
        return floor;
    }

    public void setFloor(long floor) {
        this.floor = floor;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", floor=" + floor +
                ", teacherId=" + teacherId +
                '}';
    }
}
