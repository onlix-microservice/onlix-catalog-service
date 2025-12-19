package org.onlix.catalog.product.exception;

import lombok.Getter;
import org.onlix.catalog.core.exception.BaseErrorCode;

@Getter
public class ProductCustomException extends RuntimeException {

    private final BaseErrorCode errorCode;

    // 기본 메시지 사용
    public ProductCustomException(BaseErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    // 보다 상세한 Message를 로그로 남기거나, 응답 메세지로 제공할 경우
    public ProductCustomException(BaseErrorCode errorCode, String detailMessage) {
        super(detailMessage);
        this.errorCode = errorCode;
    }
}
