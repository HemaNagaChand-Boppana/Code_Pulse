import api from "../api/axios";
import type { User } from "../types/User";

export const getUser = async (
  userId: number
): Promise<User> => {

  const response =
    await api.get(
      `/api/users/${userId}`
    );

  return response.data;
};

export const updateUser = async (
  userId: number,
  user: Partial<User>
): Promise<User> => {

  const response =
    await api.put(
      `/api/users/${userId}`,
      user
    );

  return response.data;
};