package com.extension.block.extension.ui.dto.response;

import com.extension.block.extension.repository.dto.BlockFixedFileExtensionData;
import lombok.Getter;

import java.util.List;

@Getter
public class BlockFixedFileExtensionResponse {

    private final List<BlockFixedFileExtensionData> data;

    public BlockFixedFileExtensionResponse(List<BlockFixedFileExtensionData> data) {
        this.data = data;
    }
}
