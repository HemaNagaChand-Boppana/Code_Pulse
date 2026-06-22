import api from "../api/axios";
import type { GithubActivity }
from "../types/GithubActivity";

export const getGithubActivity =
  async (
    username: string
  ): Promise<GithubActivity[]> => {

    const response =
      await api.get(
        `/api/github/activity/${username}`
      );

    return response.data;
  };