import api from "../api/axios";

import type {
  PlatformAccount
} from "../types/PlatformAccount";

export const getPlatformAccounts =
  async (
    userId: number
  ): Promise<PlatformAccount[]> => {

    const response =
      await api.get(
        `/api/platform-accounts/user/${userId}`
      );

    return response.data;
  };

export const updatePlatformAccount =
  async (
    accountId: number,
    username: string
  ) => {

    const response =
      await api.put(
        `/api/platform-accounts/${accountId}`,
        {
          username,
        }
      );

    return response.data;
  };