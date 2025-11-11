package Model;

import java.time.LocalDate;


public class MahasiswaRedflag {
    
    private String nim;
    private String nama;
    private String zodiak;
    private LocalDate tanggalEntri; 

    
    public MahasiswaRedflag(String nim, String nama, String zodiak, LocalDate tanggalEntri) {
        this.nim = nim;
        this.nama = nama;
        this.zodiak = zodiak;
        this.tanggalEntri = tanggalEntri;
    }

    
    public String getNim() { return nim; }
    public String getNama() { return nama; }
    public String getZodiak() { return zodiak; }
    public LocalDate getTanggalEntri() { return tanggalEntri; }

    
    public void setNim(String nim) { this.nim = nim; }
    public void setNama(String nama) { this.nama = nama; }
    public void setZodiak(String zodiak) { this.zodiak = zodiak; }
    public void setTanggalEntri(LocalDate tanggalEntri) { this.tanggalEntri = tanggalEntri; }
}