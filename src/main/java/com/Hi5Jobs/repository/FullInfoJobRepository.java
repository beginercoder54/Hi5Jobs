package com.Hi5Jobs.repository;

import com.Hi5Jobs.models.FullinfoJob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class FullInfoJobRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public class JobDetailMapper implements RowMapper< FullinfoJob> {

        @Override
        public FullinfoJob mapRow(ResultSet rs, int rowNum) throws SQLException {
            FullinfoJob job = new FullinfoJob();

            // From Users table
            job.setUserID(rs.getInt("UserID"));
            job.setAccountID(rs.getInt("accountID"));
            job.setName(rs.getString("Name"));
            job.setEmail(rs.getString("Email"));
            job.setPhoneNumber(rs.getString("PhoneNumber"));
            job.setAddress(rs.getString("Address"));

            // From Job table
            job.setJobID(rs.getInt("JobID"));
            job.setTitle(rs.getString("Title"));
            job.setDescriptionJob(rs.getString("DecriptionJob"));
            job.setLocation(rs.getString("Location"));
            job.setSalary(rs.getString("Salary"));
            job.setRequirement(rs.getString("Requirement"));
            job.setGentle(rs.getString("Gentle"));
            job.setNumberofRecruiment(rs.getInt("NumberRecruitment"));

            Date uploadDate = rs.getDate("UploadDate");
            if (uploadDate != null) {
                job.setUploadDate(uploadDate.toLocalDate());
            }

            job.setStatus(rs.getInt("Status"));
            job.setAge(rs.getString("Age"));
            job.setSalaryType(rs.getString("salaryType"));

            // From Employer table
            job.setCompanyName(rs.getString("Companyname"));
            job.setTaxcode(rs.getString("TaxCode"));
            job.setCompanyDescription(rs.getString("CompanyDecription"));
            job.setImgCompany(rs.getBytes("ImgCompany"));

            return job;
        }
    }

    public List<FullinfoJob> getAllJobsWithEmployerInfo() {
        String sql = "SELECT u.UserID, u.accountID, u.Name, u.Email, u.PhoneNumber, u.Address,"
                + " j.JobID, j.Title, j.DecriptionJob, j.Location, j.Salary, j.Requirement, j.Gentle,"
                + " j.NumberRecruitment, j.UploadDate, j.Status, j.Age, j.salaryType,"
                + " e.Companyname, e.TaxCode, e.CompanyDecription, e.ImgCompany "
                + "FROM Job j "
                + "JOIN Users u ON j.UserID = u.UserID "
                + "JOIN Employer e ON u.UserID = e.UserID "
                + "WHERE j.Status = 1";

        return jdbcTemplate.query(sql, new JobDetailMapper());
    }

    public List<FullinfoJob> searchJobs(String keyword) {
        String sql = "SELECT u.UserID, u.accountID, u.Name, u.Email, u.PhoneNumber, u.Address,"
                + " j.JobID, j.Title, j.DecriptionJob, j.Location, j.Salary, j.Requirement, j.Gentle,"
                + " j.NumberRecruitment, j.UploadDate, j.Status, j.Age, j.salaryType,"
                + " e.Companyname, e.TaxCode, e.CompanyDecription, e.ImgCompany "
                + "FROM Job j "
                + "JOIN Users u ON j.UserID = u.UserID "
                + "JOIN Employer e ON u.UserID = e.UserID "
                + "WHERE j.Title LIKE ? OR e.Companyname LIKE ?";

        String keywordLike = "%" + keyword + "%";
        return jdbcTemplate.query(sql, new JobDetailMapper(), keywordLike, keywordLike);
    }

    public FullinfoJob findByID(int jobID) {
        String sql = "SELECT u.UserID, u.accountID, u.Name, u.Email, u.PhoneNumber, u.Address,"
                + " j.JobID, j.Title, j.DecriptionJob, j.Location, j.Salary, j.Requirement, j.Gentle,"
                + " j.NumberRecruitment, j.UploadDate, j.Status, j.Age, j.salaryType,"
                + " e.Companyname, e.TaxCode, e.CompanyDecription, e.ImgCompany "
                + "FROM Job j "
                + "JOIN Users u ON j.UserID = u.UserID "
                + "JOIN Employer e ON u.UserID = e.UserID "
                + "WHERE j.JobID = ?";

        List<FullinfoJob> jobs = jdbcTemplate.query(sql, new JobDetailMapper(), jobID);
        return jobs.isEmpty() ? null : jobs.get(0);
    }

    public List<FullinfoJob> findByUserID(int UserID,int jobID) {
        String sql = "SELECT u.UserID, u.accountID, u.Name, u.Email, u.PhoneNumber, u.Address,"
                + " j.JobID, j.Title, j.DecriptionJob, j.Location, j.Salary, j.Requirement, j.Gentle,"
                + " j.NumberRecruitment, j.UploadDate, j.Status, j.Age, j.salaryType,"
                + " e.Companyname, e.TaxCode, e.CompanyDecription, e.ImgCompany "
                + "FROM Job j "
                + "JOIN Users u ON j.UserID = u.UserID "
                + "JOIN Employer e ON u.UserID = e.UserID "
                + "WHERE u.UserID = ? AND j.JobID != ?";
        return jdbcTemplate.query(sql, new JobDetailMapper(), UserID,jobID);  
    }
}
