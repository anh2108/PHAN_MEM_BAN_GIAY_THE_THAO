
package da_bangiay.Service;
import da_bangiay.Model.ChucVu;
import da_bangiay.Repository.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChucVu_Service {
    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;
    
    public List<ChucVu> getAll(){
        sql = "SELECT id, ChucVu, NguoiTao, NguoiSua, NgayTao, NgaySua FROM ChucVu";
        List<ChucVu> listcv = new ArrayList();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ChucVu cv = new ChucVu(rs.getInt(1), rs.getBoolean(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getDate(6));
                listcv.add(cv);
            }
            return listcv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ChucVu getCV(int id){
        sql = "SELECT NhanVien.id, ChucVu, NhanVien.NguoiTao, NhanVien.NguoiSua, NhanVien.NgayTao, NhanVien.NgaySua FROM ChucVu WHERE id = ?";
        ChucVu cv = null;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, cv.getId());
            rs = ps.executeQuery();
            while(rs.next()){
                cv = new ChucVu(rs.getInt(1), rs.getBoolean(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getDate(6));
            }
            return cv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int insert (ChucVu cv){
        sql = "INSERT INTO ChucVu (id, ChucVu, NguoiTao, NguoiSua, NgayTao, NgaySua) VALUES (?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, cv.getId());
            ps.setObject(2, cv.isChucVu());
            ps.setObject(3, cv.getNguoiTao());
            ps.setObject(4, cv.getNguoiSua());
            ps.setObject(5, cv.getNgayTao());
            ps.setObject(6, cv.getNgaySua());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int update (int id, ChucVu cv){
        sql = "UPDATE ChucVu SET ChucVu = ?, NguoiTao = ?, NguoiSua = ?, NgayTao = ?, NgaySua = ? WHERE id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, cv.isChucVu());
            ps.setObject(2, cv.getNguoiTao());
            ps.setObject(3, cv.getNguoiSua());
            ps.setObject(4, cv.getNgayTao());
            ps.setObject(5, cv.getNgaySua());
            ps.setObject(6, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int delete (int id){
        sql = "DELETE FROM ChucVu WHERE id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
