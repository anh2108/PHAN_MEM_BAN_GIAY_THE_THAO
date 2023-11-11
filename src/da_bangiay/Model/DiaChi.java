package da_bangiay.Model;

import java.util.Date;

public class DiaChi {

    private int id;
    private int idKH;
    private String duong;
    private String thanhPho;
    private String tinh;
    private String quocGia;
    private String trangThai;
    private int createBy;
    private int lanSC;
    private Date createAt;
    private int deleted;

    public DiaChi() {
    }

    public DiaChi(int id, int idKH, String duong, String thanhPho, String tinh, String quocGia, String trangThai, int createBy, int lanSC, Date createAt, int deleted) {
        this.id = id;
        this.idKH = idKH;
        this.duong = duong;
        this.thanhPho = thanhPho;
        this.tinh = tinh;
        this.quocGia = quocGia;
        this.trangThai = trangThai;
        this.createBy = createBy;
        this.lanSC = lanSC;
        this.createAt = createAt;
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public int getLanSC() {
        return lanSC;
    }

    public void setLanSC(int lanSC) {
        this.lanSC = lanSC;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
}
