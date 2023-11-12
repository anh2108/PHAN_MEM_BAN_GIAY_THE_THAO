package da_bangiay.Model;

import java.util.Date;

public class KhachHang {

    private int id;
    private String name;
    private String phone;
    private boolean gender;
    private String email;
    private int createBy;
    private int updateBy;
    private Date createAt;
    private Date updateAt;
    private int idDC;

    public KhachHang() {
    }

    public KhachHang(int id, String name, String phone, boolean gender, String email, Date createAt, Date updateAt) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.email = email;
        this.createAt = createAt;
    }

    public KhachHang(int id, String name, String phone, boolean gender, String email, int createBy, int updateBy, Date createAt, Date updateAt, int idDC) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.email = email;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.idDC = idDC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getIdDC() {
        return idDC;
    }

    public void setIdDC(int idDC) {
        this.idDC = idDC;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public int getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(int updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
