package main.service;

import main.api.request.SettingsRequest;
import main.api.response.ApiSettingsResponse;
import main.api.response.SettingsResponse;
import main.model.entities.GlobalSetting;
import main.repository.GlobalSettingsRepository;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SettingsService {

    @Value("${settings.multiUserMode}")
    private String multiUserModeSetting;

    @Value("${settings.postPremoderation}")
    private String postPremoderationSetting;

    @Value("${settings.statisticsIsPublic}")
    private String statisticsIsPublicSetting;

    @Value("${settings.errorMsg}")
    private String errorMsg;

    @Autowired
    private GlobalSettingsRepository globalSettingsRepository;

    @Autowired
    private UserRepository userRepository;

    public SettingsResponse getGlobalSettings() {
        Iterable<GlobalSetting> globalSettingsRepositoryAll = globalSettingsRepository.findAll();
        SettingsResponse settingsResponse = new SettingsResponse();
        for (GlobalSetting globalSetting : globalSettingsRepositoryAll) {
            if (globalSetting.getCode().equals(multiUserModeSetting)) {
                settingsResponse.setMultiuserMode(globalSetting.getValue().equals("YES"));
            } else if (globalSetting.getCode().equals(postPremoderationSetting)) {
                settingsResponse.setPostPremoderation(globalSetting.getValue().equals("YES"));
            } else {
                settingsResponse.setStatisticsIsPublic(globalSetting.getValue().equals("YES"));
            }
        }
        return settingsResponse;
    }

    public ApiSettingsResponse updateSettings(SettingsRequest request) {
        ApiSettingsResponse response = new ApiSettingsResponse();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {
            return response;
        }

        User user = (User) authentication.getPrincipal();
        main.model.entities.User currentUser = userRepository.findByEmail(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(user.getUsername()));

        if (currentUser.getIsModerator() != 1) {
            return response;
        }

        GlobalSetting multiUserMode = globalSettingsRepository.findByCode(multiUserModeSetting)
                .orElseThrow(() -> new UsernameNotFoundException(errorMsg + multiUserModeSetting));

        if (!multiUserMode.getValue().equals(request.isMultiuserMode() ? "YES" : "NO")) {
            multiUserMode.setValue(request.isMultiuserMode() ? "YES" : "NO");
            globalSettingsRepository.save(multiUserMode);
        }

        GlobalSetting postPremoderation = globalSettingsRepository.findByCode(postPremoderationSetting)
                .orElseThrow(() -> new UsernameNotFoundException(errorMsg + postPremoderationSetting));

        if (!postPremoderation.getValue().equals(request.isPostPremoderation() ? "YES" : "NO")) {
            postPremoderation.setValue(request.isPostPremoderation() ? "YES" : "NO");
            globalSettingsRepository.save(postPremoderation);
        }

        GlobalSetting statisticsIsPublic = globalSettingsRepository.findByCode(statisticsIsPublicSetting)
                .orElseThrow(() -> new UsernameNotFoundException(errorMsg + statisticsIsPublicSetting));

        if (!statisticsIsPublic.getValue().equals(request.isStatisticsIsPublic() ? "YES" : "NO")) {
            statisticsIsPublic.setValue(request.isStatisticsIsPublic() ? "YES" : "NO");
            globalSettingsRepository.save(statisticsIsPublic);
        }

        response.setResult(true);
        return response;
    }
}
