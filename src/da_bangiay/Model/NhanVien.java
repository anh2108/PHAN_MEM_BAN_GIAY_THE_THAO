
package da_bangiay.Model;

import java.util.Date;


public class NhanVien {
    private int id;
    private int id_ChucVu;
    private String hoTen;
    private String email;
    private long SDT;
    private String matKhau;
    private String diaChi;
    private String trangThai;
    private int nguoiTao;
    private int nguoiSua;
    private Date ngayTao;
    private Date ngaySua;

    public NhanVien() {
    }

    public NhanVien(int id, int id_ChucVu, String hoTen, String email, long SDT, String matKhau, String diaChi, String trangThai, int nguoiTao, int nguoiSua, Date ngayTao, Date ngaySua) {
        this.id = id;
        this.id_ChucVu = id_ChucVu;
        this.hoTen = hoTen;
        this.email = email;
        this.SDT = SDT;
        this.matKhau = matKhau;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
        this.nguoiTao = nguoiTao;
        this.nguoiSua = nguoiSua;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_ChucVu() {
        return id_ChucVu;
    }

    public void setId_ChucVu(int id_ChucVu) {
        this.id_ChucVu = id_ChucVu;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getSDT() {
        return SDT;
    }

    public void setSDT(long SDT) {
        this.SDT = SDT;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(int nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public int getNguoiSua() {
        return nguoiSua;
    }

    public void setNguoiSua(int nguoiSua) {
        this.nguoiSua = nguoiSua;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }
    
    public Object[] toDataRow(){
           return new Object[]{
               this.id,
               this.id_ChucVu,
               this.hoTen,
               this.email,
               this.SDT, 
               this.matKhau, 
               this.diaChi, 
               this.trangThai,
               this.nguoiTao,
               this.nguoiSua,
               this.ngayTao,
               this.ngaySua
           };
    }
}
