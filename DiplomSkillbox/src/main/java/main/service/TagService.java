package main.service;

import main.api.response.TagResponse;
import main.api.response.responsedto.TagResponseDTO;
import main.model.entities.Tag;
import main.model.enumerated.ModerationStatus;
import main.repository.PostRepository;
import main.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private PostRepository postRepository;

    public TagResponse getTags(String query) {
        List<TagResponseDTO> tagList = new ArrayList<>();
        TagResponse tagResponse = new TagResponse();

        if (query.equals("empty")) {
            Iterable<Tag> tags = tagRepository.findAll();
            for (Tag tag : tags) {
                TagResponseDTO tagResponseDTO = new TagResponseDTO(tag.getName(), getTagWeight(tag));
                tagList.add(tagResponseDTO);
            }
        } else {
            List<Tag> tags = tagRepository.findTagsByPartOfName(query);
            for (Tag tag : tags) {
                TagResponseDTO tagResponseDTO = new TagResponseDTO(tag.getName(), getTagWeight(tag));
                tagList.add(tagResponseDTO);
            }
        }

        tagResponse.setTags(tagList);
        return tagResponse;
    }

    private double getTagWeight(Tag tag) {
        int countAllPosts = postRepository
                .findAllPostsByModStatusAndActivityStatus((short) 1, ModerationStatus.ACCEPTED).size();

        int countPostsByTag = tagRepository.findPostsByTagId(tag.getId()).size();
        double tagWeightUnNormal = (double) countPostsByTag / countAllPosts;

        double mostPopularTagWeightUnNormal = (double) tagRepository.findPostsByTagId(
                tagRepository.findMostPopularTagNative().getId()).size() / countAllPosts;

        double koeff = 1 / mostPopularTagWeightUnNormal;

        return tagWeightUnNormal * koeff;
    }
}
