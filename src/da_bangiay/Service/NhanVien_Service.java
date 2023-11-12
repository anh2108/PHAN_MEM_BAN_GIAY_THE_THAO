
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
        sql = "";
        List<NhanVien> listnv = new ArrayList();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public NhanVien getNV(int id_ChucVu){
        sql = "";
        NhanVien nv = null;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getId_ChucVu());
            
           
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int insert (NhanVien nv){
        sql = "";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int update (String id_ChucVu, NhanVien nv){
        sql = "";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int delete(int id_ChucVu){
        sql = "";
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
