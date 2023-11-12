
package da_bangiay.Service;
import da_bangiay.Model.NhanVien;
import da_bangiay.Repository.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhanVien_Service {
    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;
    
    public List<NhanVien> getAll(){
        sql = "SELECT id, id_ChucVu, MaNhanVien, HoTen, SoDt, Email, MatKhau, MaOtp, DiaChi, TrangThai, NguoiTao, NguoiSua, NgayTao, NgaySua";
        List<NhanVien> listnv = new ArrayList();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                NhanVien nv = new NhanVien(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getBoolean(10), rs.getInt(11), rs.getInt(12), rs.getDate(13), rs.getDate(14));
                listnv.add(nv);
            }
            return listnv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public NhanVien getNV(int id_ChucVu){
        sql = "SELECT NhanVien.id, NhanVien.MaNhanVien, NhanVien.HoTen, NhanVien.SoDt, NhanVien.Email, NhanVien.MatKhau, NhanVien.MaOtp, NhanVien.DiaChi, NhanVien.TrangThai, NhanVien.NguoiTao, NhanVien.NguoiSua, NhanVien.NgayTao, NhanVien.NgaySua, ChucVu.ChucVu FROM NhanVien INNER JOIN ChucVu ON NhanVien.id_ChucVu = ChucVu.id";
        NhanVien nv = null;
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int insert (NhanVien nv){
        sql = "INSERT INTO NhanVien (id_ChucVu = ?, MaNhanVien, HoTen, SoDt, Email, MatKhau, MaOtp, DiaChi, TrangThai, NguoiTao, NguoiSua, NgayTao, NgaySua) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getId_ChucVu());
            ps.setObject(2, nv.getMaNV());
            ps.setObject(3, nv.getHoTen());
            ps.setObject(4, nv.getSDT());
            ps.setObject(5, nv.getEmail());
            ps.setObject(6, nv.getMatKhau());
            ps.setObject(7, nv.getMaOTP());
            ps.setObject(8, nv.getDiaChi());
            ps.setObject(9, nv.isTrangThai());
            ps.setObject(10, nv.getNguoiTao());
            ps.setObject(11, nv.getNguoiSua());
            ps.setObject(12, nv.getNgayTao());
            ps.setObject(13, nv.getNgaySua());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int update (int id_ChucVu, NhanVien nv){
        sql = "UPDATE NhanVien SET MaNhanVien = ?, HoTen = ?, SoDt = ?, Email= ?, MatKhau = ?, MaOtp = ?, DiaChi = ?, TrangThai = ?, NguoiTao = ?, NguoiSua = ?, NgayTao = ?, NgaySua = ? WHERE id_ChucVu = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getHoTen());
            ps.setObject(2, nv.getSDT());
            ps.setObject(3, nv.getEmail());
            ps.setObject(4, nv.getMatKhau());
            ps.setObject(5, nv.getMaOTP());
            ps.setObject(6, nv.getDiaChi());
            ps.setObject(7, nv.isTrangThai());
            ps.setObject(8, nv.getNguoiTao());
            ps.setObject(9, nv.getNguoiSua());
            ps.setObject(10, nv.getNgayTao());
            ps.setObject(11, nv.getNgaySua());
            ps.setObject(12, id_ChucVu);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int delete(int id_ChucVu){
        sql = "DELETE FROM NhanVien WHERE id_ChucVu = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id_ChucVu);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
