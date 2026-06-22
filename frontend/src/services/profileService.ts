import api from "../api/axios";
import type { Profile } from "../types/Profile";

export const getProfile = async (
  userId: number
): Promise<Profile> => {

  const response = await api.get(
    `/api/profile/${userId}`
  );

  return response.data;
};