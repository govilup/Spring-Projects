package com.springbatch.listner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springbatch.entity.AnimeDTO;

@Component
public class JobCompletionNotificationListener implements JobExecutionListener{
	
	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);
	
	private final JdbcTemplate jdbcTemplate;

	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("============ JOB FINISHED ============ Verifying the results....\n");
			
			List<AnimeDTO> results = jdbcTemplate.query("SELECT id, title, description FROM animes", new RowMapper<AnimeDTO>() {
				@Override
				public AnimeDTO mapRow(ResultSet rs, int row) throws SQLException {
					return new AnimeDTO(rs.getString(1), rs.getString(2), rs.getString(3));
				}
			});

			for (AnimeDTO AnimeDTO : results) {
				log.info("Discovered <" + AnimeDTO + "> in the database.");
			}

		}
		
	}

	@Override
	public void beforeJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		
	}

}