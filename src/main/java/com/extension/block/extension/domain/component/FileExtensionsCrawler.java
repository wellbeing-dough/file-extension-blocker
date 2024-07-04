package com.extension.block.extension.domain.component;

import com.extension.block.extension.domain.entity.FileExtension;
import com.extension.block.extension.repository.FileExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FileExtensionsCrawler {

    private final FileExtensionRepository fileExtensionRepository;

    @Transactional
    @Scheduled(cron = "0 0 0 1 */3 *")  // 3개월마다 첫째 날 자정에 실행
    public void fetchAndSaveNewExtensions() throws IOException {
        String url = "https://namu.wiki/w/%ED%99%95%EC%9E%A5%EC%9E%90/%EB%AA%A9%EB%A1%9D";
        Document document = Jsoup.connect(url).get();

        List<FileExtension> fileExtensions = new ArrayList<>();

        // Select the table containing the "종류" and "비고" columns
        Elements tables = document.select("table:contains(종류)");

        for (Element table : tables) {
            Elements rows = table.select("tr");
            for (Element row : rows) {
                Elements cells = row.select("td");
                if (cells.size() == 2) {
                    String type = cells.get(0).text().trim().replace("§", "");
                    String notes = cells.get(1).text().trim();
                    FileExtension fileExtension = new FileExtension(type, notes);
                    fileExtensions.add(fileExtension);
                }
            }
        }

        List<FileExtension> newExtensions = filterNewExtensions(fileExtensions);

        // 새로운 커스텀 확장자를 모두 저장
        fileExtensionRepository.saveAll(newExtensions);
    }

    public List<FileExtension> filterNewExtensions(List<FileExtension> fileExtensions) {
        // 데이터베이스에서 모든 기존 항목을 가져옴
        List<FileExtension> existingExtensions = fileExtensionRepository.findAll();

        // 빠른 조회를 위해 기존 항목의 extensionName을 집합으로 생성
        Set<String> existingExtensionNames = existingExtensions.stream()
                .map(FileExtension::getExtensionName)
                .collect(Collectors.toSet());

        // 데이터베이스에 이미 존재하지 않는 확장자만 필터링
        return fileExtensions.stream()
                .filter(extension -> !existingExtensionNames.contains(extension.getExtensionName()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void crawlAndSave() throws IOException {
        String url = "https://namu.wiki/w/%ED%99%95%EC%9E%A5%EC%9E%90/%EB%AA%A9%EB%A1%9D";
        // User-Agent 헤더 추가
        Document document = Jsoup.connect(url).get();
        List<FileExtension> fileExtensions = new ArrayList<>();

        Elements tables = document.select("table:contains(종류)");

        for (Element table : tables) {
            Elements rows = table.select("tr");
            for (Element row : rows) {
                Elements cells = row.select("td");
                if (cells.size() == 2) {
                    String type = cells.get(0).text().trim();
                    String notes = cells.get(1).text().trim();
                    FileExtension fileExtension = new FileExtension(type, notes);
                    fileExtensions.add(fileExtension);
                }
            }
        }

        // Save all extracted custom extensions to the repository
        fileExtensionRepository.saveAll(fileExtensions);
    }

}
