package da_bangiay.Model;

import java.util.Date;

public class DiaChi {

    private int id;
    private String duong;
    private String thanhPho;
    private String tinh;
    private String quocGia;
    private int createBy;
    private int updateBy;
    private Date createAt;
    private Date updateAt;

    public DiaChi() {
    }

    public DiaChi(int id, String duong, String thanhPho, String tinh, String quocGia, int createBy, int updateBy, Date createAt, Date updateAt) {
        this.id = id;
        this.duong = duong;
        this.thanhPho = thanhPho;
        this.tinh = tinh;
        this.quocGia = quocGia;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDuong() {
        return duong;
    }

    public void setDuong(String duong) {
        this.duong = duong;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public int getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(int updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
