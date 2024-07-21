public class Certificate {
    private int certificatedId;
    private String certificateName;
    private String certificateRank;
    private String certificatedDate;

    public Certificate() {
    }

    public Certificate(int certificatedId, String certificateName, String certificateRank, String certificatedDate) {
        this.certificatedId = certificatedId;
        this.certificateName = certificateName;
        this.certificateRank = certificateRank;
        this.certificatedDate = certificatedDate;
    }

    public int getCertificatedId() {
        return certificatedId;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public String getCertificateRank() {
        return certificateRank;
    }

    public String getCertificatedDate() {
        return certificatedDate;
    }

    public void setCertificatedId(int certificatedId) {
        this.certificatedId = certificatedId;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public void setCertificateRank(String certificateRank) {
        this.certificateRank = certificateRank;
    }

    public void setCertificatedDate(String certificatedDate) {
        this.certificatedDate = certificatedDate;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "certificatedId=" + certificatedId +
                ", certificateName='" + certificateName + '\'' +
                ", certificateRank='" + certificateRank + '\'' +
                ", certificatedDate='" + certificatedDate + '\'' +
                '}';
    }
}
