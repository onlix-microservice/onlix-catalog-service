package org.onlix.catalog.product.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.onlix.catalog.core.exception.BaseErrorCode;

/**
 * ErrorCode Code 규칙: "PR" + HttpStatusCode + INDEX
 * - ex) PR4000, PR4040, PR5000
 */
@Getter
@AllArgsConstructor
public enum ProductCustomErrorCode implements BaseErrorCode {

    NOT_FOUND("PR4040", 404, "해당 상품이 존재하지 않습니다"),
    NOT_VISIBLE("PR4041", 404, "게시 중지된 상품입니다.");

    private final String code;
    private final int statusCode;
    private final String message;
}
