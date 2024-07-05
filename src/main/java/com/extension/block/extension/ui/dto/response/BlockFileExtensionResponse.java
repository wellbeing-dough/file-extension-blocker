package com.extension.block.extension.ui.dto.response;

import com.extension.block.extension.repository.dto.BlockedFileExtensionData;
import lombok.Getter;

import java.util.List;

@Getter
public class BlockFileExtensionResponse {

    private final List<BlockedFileExtensionData> data;

    public BlockFileExtensionResponse(List<BlockedFileExtensionData> data) {
        this.data = data;
    }
}
