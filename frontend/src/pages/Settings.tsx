import { useEffect, useState } from "react";

import MainLayout from "../layouts/MainLayout";

import type { User } from "../types/User";
import type { PlatformAccount } from "../types/PlatformAccount";

import {
  getUser,
  updateUser,
} from "../services/userService";

import {
  getPlatformAccounts,
  updatePlatformAccount,
} from "../services/platformAccountService";

export default function Settings() {

  const [user, setUser] =
    useState<User | null>(null);

  const [accounts, setAccounts] =
    useState<PlatformAccount[]>([]);

  const [saving, setSaving] =
    useState(false);

  const [message, setMessage] =
    useState("");

  useEffect(() => {

    const loadData = async () => {

      try {

        const userData =
          await getUser(1);

        const accountData =
          await getPlatformAccounts(1);

        setUser(userData);

        setAccounts(accountData);

      } catch (error) {

        console.error(error);
      }
    };

    loadData();

  }, []);

  const handleUserChange = (
    field: keyof User,
    value: string
  ) => {

    if (!user) return;

    setUser({
      ...user,
      [field]:
        field === "year"
          ? Number(value)
          : value,
    });
  };

  const handleAccountChange = (
    accountId: number,
    username: string
  ) => {

    setAccounts(
      accounts.map(account =>
        account.id === accountId
          ? {
              ...account,
              username,
            }
          : account
      )
    );
  };

  const handleSave = async () => {

    if (!user) return;

    try {

      setSaving(true);

      setMessage("");

      await updateUser(
        user.id,
        {
          name: user.name,
          email: user.email,
          college: user.college,
          branch: user.branch,
          year: user.year,
        }
      );

      for (const account of accounts) {

        await updatePlatformAccount(
          account.id,
          account.username
        );
      }

      setMessage(
        "Changes saved successfully!"
      );

    } catch (error) {

      console.error(error);

      setMessage(
        "Failed to save changes."
      );

    } finally {

      setSaving(false);
    }
  };

  if (!user) {

    return (
      <MainLayout>
        Loading...
      </MainLayout>
    );
  }

  return (
    <MainLayout>

      <h1 className="text-4xl font-bold mb-6">
        Settings
      </h1>

      <div className="bg-white rounded-xl shadow p-6">

        <h2 className="text-2xl font-bold mb-4">
          Profile Information
        </h2>

        <div className="grid md:grid-cols-2 gap-4">

          <input
            className="border p-3 rounded"
            placeholder="Name"
            value={user.name}
            onChange={(e) =>
              handleUserChange(
                "name",
                e.target.value
              )
            }
          />

          <input
            className="border p-3 rounded"
            placeholder="Email"
            value={user.email}
            onChange={(e) =>
              handleUserChange(
                "email",
                e.target.value
              )
            }
          />

          <input
            className="border p-3 rounded"
            placeholder="College"
            value={user.college}
            onChange={(e) =>
              handleUserChange(
                "college",
                e.target.value
              )
            }
          />

          <input
            className="border p-3 rounded"
            placeholder="Branch"
            value={user.branch}
            onChange={(e) =>
              handleUserChange(
                "branch",
                e.target.value
              )
            }
          />

          <input
            type="number"
            className="border p-3 rounded"
            placeholder="Year"
            value={user.year}
            onChange={(e) =>
              handleUserChange(
                "year",
                e.target.value
              )
            }
          />

        </div>

        <h2 className="text-2xl font-bold mt-8 mb-4">
          Platform Accounts
        </h2>

        <div className="space-y-4">

          {accounts.map(account => (

            <div key={account.id}>

              <label className="block mb-2 font-semibold">

                {account.platform}

              </label>

              <input
                className="border p-3 rounded w-full"
                value={account.username}
                onChange={(e) =>
                  handleAccountChange(
                    account.id,
                    e.target.value
                  )
                }
              />

            </div>

          ))}

        </div>

        <button
          onClick={handleSave}
          disabled={saving}
          className="
            mt-6
            bg-blue-600
            text-white
            px-6
            py-3
            rounded-lg
            hover:bg-blue-700
            disabled:bg-gray-400
          "
        >
          {saving
            ? "Saving..."
            : "Save Changes"}
        </button>

        {message && (

          <p className="mt-4 text-green-600">

            {message}

          </p>

        )}

      </div>

    </MainLayout>
  );
}