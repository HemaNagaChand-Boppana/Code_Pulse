import api from "../api/axios";

export const refreshProfile =
  async (userId: number) => {

    const response =
      await api.post(
        `/api/profile/refresh/${userId}`
      );

    return response.data;
};