package com.springbatch.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.springbatch.entity.AnimeDTO;

public class AnimeProcessor implements ItemProcessor<AnimeDTO, AnimeDTO> {

	private static final Logger log = LoggerFactory.getLogger(AnimeProcessor.class);

	@Override
	public AnimeDTO process(final AnimeDTO item) throws Exception {
		final String id = item.getId();
		final String title = item.getTitle();
		final String description = item.getDescription();

		final AnimeDTO transformedAnimeDTO = new AnimeDTO(id, title, description);

		log.info("Converting (" + item + ") into (" + transformedAnimeDTO + ")");

		return transformedAnimeDTO;
	}
}
