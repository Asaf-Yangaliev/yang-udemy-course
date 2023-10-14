package uz.yangaliev.microservices.udemycource.yangudemycourse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.yangaliev.microservices.udemycource.yangudemycourse.dto.UserV1Dto;
import uz.yangaliev.microservices.udemycource.yangudemycourse.dto.UserV2Dto;

@RestController
public class UserVersioningController {

    /**
     *
     * @return
     * returns user version=1 using path versioning
     */

    @GetMapping("/user/v1")
    public UserV1Dto getUserV1() {
        return UserV1Dto.builder()
                .name("Asaf")
                .surname("Yangaliev")
                .build();
    }

    /**
     *
     * @return
     * returns user version=2 using path versioning
     */

    @GetMapping("/user/v2")
    public UserV2Dto getUserV2() {
        return UserV2Dto.builder()
                .fullName("Asaf Yangaliev")
                .build();
    }

    ////////////////////////////////////////////////////////////////////////

    /**
     *
     * @return
     * returns user version=1 using param versioning
     */
    @GetMapping(value = "/user/param", params = "version=1")
    public UserV1Dto getUserParamV1() {
        return UserV1Dto.builder()
                .name("Asaf")
                .surname("Yangaliev")
                .build();

    }

    /**
     *
     * @return
     * returns user version=2 using param versioning
     */
    @GetMapping(value = "/user/param", params = "version=2")
    public UserV2Dto getUserParamV2() {
        return UserV2Dto.builder()
                .fullName("Asaf Yangaliev")
                .build();
    }

    ////////////////////////////////////////////////////////////////////////

    /**
     *
     * @return
     * returns user version=1 using header versioning
     */
    @GetMapping(value = "/user/header", headers = "X-API-VERSION=1")
    public UserV1Dto getUserHeaderV1() {
        return UserV1Dto.builder()
                .name("Asaf")
                .surname("Yangaliev")
                .build();

    }

    /**
     *
     * @return
     * returns user version=2 using header versioning
     */
    @GetMapping(value = "/user/header", headers = "X-API-VERSION=2")
    public UserV2Dto getUserHeaderV2() {
        return UserV2Dto.builder()
                .fullName("Asaf Yangaliev")
                .build();
    }

    ////////////////////////////////////////////////////////////////////////

    /**
     *
     * @return
     * returns user version=1 using Media-Type versioning
     */
    @GetMapping(value = "/user/media-type", produces = "application/vnd.company.app-v1+json")
    public UserV1Dto getUserMediaTypeV1() {
        return UserV1Dto.builder()
                .name("Asaf")
                .surname("Yangaliev")
                .build();

    }

    /**
     *
     * @return
     * returns user version=2 using Media-Type versioning
     */
    // 'Media-Type' header
    @GetMapping(value = "/user/media-type", produces = "application/vnd.company.app-v2+json")
    public UserV2Dto getUserMediaTypeV2() {
        return UserV2Dto.builder()
                .fullName("Asaf Yangaliev")
                .build();
    }
}
