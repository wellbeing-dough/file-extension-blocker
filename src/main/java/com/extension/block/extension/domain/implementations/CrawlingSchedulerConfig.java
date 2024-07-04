package com.extension.block.extension.domain.implementations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class CrawlingSchedulerConfig {

    private final FileExtensionsCrawler fileExtensionsCrawler;

    @Scheduled(cron = "0 0 0 1 */3 *")  // 3개월마다 첫째 날 자정에 실행
    public void fetchAndSaveNewExtensions() throws IOException {
        fileExtensionsCrawler.fetchAndSaveNewExtensions();
    }
}